package com.lishuangqi.test.factory;

/**
 * Created by michael on 2019/4/29.
 */
public class LowPersonFactory implements IAbstractFactory{
    @Override
    public Vehicle getCar() {
        return new Bike();
    }

    @Override
    public IBreakFast getBreakFast() {
        return new Orange();
    }
}
