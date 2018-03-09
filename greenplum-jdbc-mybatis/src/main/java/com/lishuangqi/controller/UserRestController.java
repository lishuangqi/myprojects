package com.lishuangqi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lishuangqi.gpdb.domain.CarFlow;
import com.lishuangqi.gpdb.service.CarFlowService;
import com.lishuangqi.gpdb.service.UserService;
import com.lishuangqi.gpdb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用户控制层
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private CarFlowService carFlowService;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findByName(userName);
    }


    @RequestMapping(value = "/api/carflow", method = RequestMethod.GET)
    public List<Map> countProvinceByMonth(@RequestParam(value = "yyyymm", required = true) String yyyymm) {
        return carFlowService.countProvinceByMonth(yyyymm);
    }

    @RequestMapping(value = "/api/carflowC", method = RequestMethod.GET)
    public JSONArray countSCCityByMonth(@RequestParam(value = "yyyymm", required = true) String yyyymm) {
        String s1 = JSON.toJSONString(carFlowService.countSCCityByMonth(yyyymm));
        return JSONArray.parseArray(s1);
    }

    @RequestMapping(value = "/api/carflowI")
    public int insertSelective(CarFlow carFlow) {
            int i = carFlowService.insertSelective(carFlow);
        return i;
    }

    @RequestMapping(value = "/api/carflowD")
    public int insertSelective(@RequestParam(value = "id", required = true) Long clxxbh) {
        int i = carFlowService.deleteByClxxbh(clxxbh);
        return i;
    }
}
