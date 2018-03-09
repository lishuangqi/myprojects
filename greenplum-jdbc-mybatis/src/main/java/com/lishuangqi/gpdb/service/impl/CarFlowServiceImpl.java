package com.lishuangqi.gpdb.service.impl;

import com.lishuangqi.gpdb.dao.CarFlowDao;
import com.lishuangqi.gpdb.domain.CarFlow;
import com.lishuangqi.gpdb.service.CarFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户业务接口层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CarFlowServiceImpl implements CarFlowService {
    @Autowired
    private CarFlowDao carFlowDao; // 主数据源

    /**
     * 根据序号最大值
     *
     * @return
     */
    @Override
    public long findByMaxClxxbh(){
        return carFlowDao.findByMaxClxxbh();
    }

    /**
     * 选择大于当前序号的值
     * @return
     */
    @Override
    public List<CarFlow> findByGreaterClxxbh(long clxxbh){
        return carFlowDao.findByGreaterClxxbh(clxxbh);
    }

    @Override
    public int insertSelective(CarFlow data) {
        System.out.println(data);
        return carFlowDao.insertSelective(data);
    }

    @Override
    public int deleteByClxxbh(long clxxbh) {
        return carFlowDao.deleteByClxxbh(clxxbh);
    }


    @Override
    public List<Map> countProvinceByMonth(String yyyy_mm) {
        return carFlowDao.countProvinceByMonth(yyyy_mm);
    }

    @Override
    public  List<Map> countSCCityByMonth(String yyyy_mm) {
        return carFlowDao.countSCCityByMonth(yyyy_mm);
    }
}
