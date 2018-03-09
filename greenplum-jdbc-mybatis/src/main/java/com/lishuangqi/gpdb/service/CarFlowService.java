package com.lishuangqi.gpdb.service;

import com.lishuangqi.gpdb.domain.CarFlow;

import java.util.List;
import java.util.Map;

/**
 * 用户业务接口层
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CarFlowService {

    /**
     * 根据序号最大值
     *
     * @return
     */
    long findByMaxClxxbh();

    /**
     * 选择大于当前序号的值
     * @return
     */
    List<CarFlow> findByGreaterClxxbh(long clxxbh);

    int insertSelective(CarFlow data);

    int deleteByClxxbh(long clxxbh);

    List<Map> countProvinceByMonth(String yyyy_mm);

    List<Map> countSCCityByMonth(String yyyy_mm);
}
