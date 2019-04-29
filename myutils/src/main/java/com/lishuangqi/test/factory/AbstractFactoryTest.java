package com.lishuangqi.test.factory;

/**
 * Created by michael on 2019/4/29.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IAbstractFactory factory = new LowPersonFactory();
        Vehicle vehicle = factory.getCar();
        IBreakFast breakFast = factory.getBreakFast();
        System.out.println("吃的早饭是：");
        breakFast.eat();
        System.out.println("上班交通工具是：");
        vehicle.gotowork();

        IAbstractFactory factory2 = new HighPersonFactory();
        vehicle = factory2.getCar();
        breakFast = factory2.getBreakFast();
        System.out.println("吃的早饭是：");
        breakFast.eat();
        System.out.println("上班交通工具是：");
        vehicle.gotowork();
    }
}
