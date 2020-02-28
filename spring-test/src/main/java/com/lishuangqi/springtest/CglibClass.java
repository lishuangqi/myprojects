package com.lishuangqi.springtest;

public class CglibClass {
    public CglibClass(){}
    public void goHome(){
        System.out.println("goHome");
    }
    public void gotoSchool(){
        System.out.println("gotoSchool");
    }
    public void oneDay() {
        goHome();
        gotoSchool();;
    }

    public void oneDayFinal() {
        goHome();
        gotoSchool();
    }
}
