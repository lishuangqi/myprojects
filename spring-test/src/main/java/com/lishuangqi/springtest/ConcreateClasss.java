package com.lishuangqi.springtest;

public class ConcreateClasss implements JavaProxyInterface {
    @Override
    public void gotoSchool() {
        System.out.println("gotoSchool");
    }

    @Override
    public void gotoWork() {
        System.out.println("gotoWork");
    }

    @Override
    public void oneDay() {
        gotoSchool();;
        gotoWork();
    }

    @Override
    public void oneDayFinal() {
       gotoSchool();
       gotoWork();
    }
}
