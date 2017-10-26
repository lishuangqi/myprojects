package com.lishuangqi.test;

/**
 * Created by michael on 2017/10/26.
 * 饿汉式单例模式
 */
public class MySingleton2 {

    //设立静态变量，直接创建实例
    private static MySingleton2 mySingleton = new MySingleton2();

    private MySingleton2(){
        //私有化构造函数
        System.out.println("-->饿汉式单例模式开始调用构造函数");
    }

    /**
     *  开放一个公有方法，判断是否已经存在实例，有返回，没有新建一个在返回
     */
    public static MySingleton2 getInstance(){
        System.out.println("-->饿汉式单例模式开始调用公有方法返回实例");
        return mySingleton;
    }
}
