package com.lishuangqi.test;

/**
 * Created by michael on 2017/10/26.
 * 懒汉式单例模式
 * 加锁
 */

public class MySingleton1a {

    //设立静态变量
    private static MySingleton1a mySingleton = null;

    private MySingleton1a(){
        //私有化构造函数
        System.out.println("-->懒汉式单例模式开始调用构造函数");
    }

    /**
     * 开放一个公有方法，判断是否已经存在实例，有返回，没有新建一个在返回
     */
    public static MySingleton1a getInstance(){
        System.out.println("-->懒汉式单例模式开始调用公有方法返回实例");
        //提高已经存在的对象访问效率
        if(null == mySingleton){
            //加锁
            synchronized(MySingleton1a.class) {
                if(null == mySingleton) {
                    System.out.println("-->懒汉式构造函数的实例当前并没有被创建");
                    mySingleton = new MySingleton1a();
                }
            }
        }else{
            System.out.println("-->懒汉式构造函数的实例已经被创建");
        }
        System.out.println("-->方法调用结束，返回单例");
        return mySingleton;
    }
}