package com.lishuangqi.gpdb.dao;

import com.lishuangqi.gpdb.domain.CarFlow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface CarFlowDao {

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

    List<Map> countProvinceByMonth(String  yyyy_mm);

    List<Map> countSCCityByMonth(String  yyyy_mm);

}
