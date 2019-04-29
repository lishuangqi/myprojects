package com.lishuangqi.test.factory;

/**
 * Created by michael on 2019/4/29.
 */
public class Bus implements Vehicle{
    @Override
    public void gotowork() {
        System.out.println("坐公交车去上班！");
    }

}
