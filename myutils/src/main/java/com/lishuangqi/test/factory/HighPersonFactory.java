package com.lishuangqi.test.factory;

/**
 * Created by michael on 2019/4/29.
 */
public class HighPersonFactory implements IAbstractFactory{
    @Override
    public Vehicle getCar() {
        return new Bus();
    }

    @Override
    public IBreakFast getBreakFast() {
        return new Milk();
    }
}
