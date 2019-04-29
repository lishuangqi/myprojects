package com.lishuangqi.test.factory;

/**
 * Created by michael on 2019/4/29.
 */
public class Bike implements Vehicle{
    @Override
    public void gotowork() {
        System.out.println("骑自行车去上班！");
    }
}
