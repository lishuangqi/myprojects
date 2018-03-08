package com.lishuangqi.gpdb.service.impl;

import com.lishuangqi.gpdb.dao.CityDao;
import com.lishuangqi.gpdb.service.UserService;
import com.lishuangqi.gpdb.dao.UserDao;
import com.lishuangqi.gpdb.domain.City;
import com.lishuangqi.gpdb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        System.out.println(user);
        City city = cityDao.findByName("四川");
        user.setCity(city);
        return user;
    }
}
