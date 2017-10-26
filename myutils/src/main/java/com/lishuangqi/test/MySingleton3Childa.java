package com.lishuangqi.test;

/**
 * Created by michael on 2017/10/26.
 */
public class MySingleton3Childa extends MySingleton3 {
    public static MySingleton3Childa getInstance() {
        return (MySingleton3Childa) MySingleton3Childa
                .getInstance("com.lishuangqi.test.MySingleton3Childa");
    }

    //随便写一个测试的方法
    public String about() {
        return "---->我是MySingleton3的第一个子类MySingleton3Childa";
    }
}
