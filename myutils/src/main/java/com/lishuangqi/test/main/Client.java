package com.lishuangqi.test.main;

import com.lishuangqi.test.*;

/**
 * Created by michael on 2017/10/26.
 * 懒汉式单例模式
 * MySingleton
 */
public class Client {
    public static void myprint() {
        System.out.println("-----------------懒汉式单例模式----------------");
        System.out.println("第一次取得实例（懒汉式）");
        MySingleton1 s1 = MySingleton1.getInstance();
        System.out.println("第二次取得实例（懒汉式）");
        MySingleton1 s2 = MySingleton1.getInstance();
        if (s1 == s2) {
            System.out.println(">>>>>s1,s2为同一实例（懒汉式）<<<<<");
        }
        System.out.println();
    }
    public static void myprint2(){
        System.out.println("-----------------饿汉式单例模式----------------");
        System.out.println("第一次取得实例（饿汉式）");
        MySingleton2 s1 = MySingleton2.getInstance();
        System.out.println("第二次取得实例（饿汉式）");
        MySingleton2 s2 = MySingleton2.getInstance();
        if(s1==s2){
            System.out.println(">>>>>s1,s2为同一实例（饿汉式）<<<<<");
        }
        System.out.println();
    }

    /**
     * 懒汉式单例模式改进
     * 实现了延迟加载
     * MySingleton2
     */
    public static void myprint2a(){
        System.out.println("---------------懒汉式单例模式改进--------------");
        System.out.println("第一次取得实例（改进懒汉式）");
        MySingleton2a s1 = MySingleton2a.getInstance();
        System.out.println("第二次取得实例（改进懒汉式）");
        MySingleton2a s2 = MySingleton2a.getInstance();
        if(s1==s2){
            System.out.println(">>>>>s1,s2为同一实例（改进懒汉式）<<<<<");
        }
        System.out.println();
    }
    /**
     * 登记式单例模式
     * MySingleton2
     */
    public static void myprint3(){
        System.out.println("-----------------登记式单例模式----------------");
        System.out.println("第一次取得实例（登记式）");
        MySingleton3 s1 = MySingleton3.getInstance(null);
        System.out.println(s1);
        System.out.println("第二次取得实例（登记式）");
        MySingleton3Childa s3 = MySingleton3Childa.getInstance();
        System.out.println(s3);
        System.out.println(s3.about());
        System.out.println("第三次取得实例（登记式）");
        MySingleton3Childb s4 = MySingleton3Childb.getInstance();
        System.out.println(s4);
        System.out.println(s4.about());
        System.out.println("第四次取得实例（非正常直接new子类的构造方法）");
        MySingleton3Childb s5 = new MySingleton3Childb();
        System.out.println(s5);
        System.out.println(s5.about());
        System.out.println("输出父类中Map保存的所有单例，可以看出，直接new出来的实例并没有存在Map中");
        System.out.println(s1.getMap());
        System.out.println();
        MySingleton3Childa s3a = MySingleton3Childa.getInstance();
        MySingleton3Childa s3b = MySingleton3Childa.getInstance();
        if(s3a==s3b){
            System.out.println(">>>>>s3a,s3b（登记式）<<<<<");
        }
        System.out.println();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Math.round(-9.6));
        //懒汉式
//        myprint();
        //饿汉式
//        myprint2();
        //懒汉式改进
        myprint2a();
        //登记式
//        myprint3();

    }

}
