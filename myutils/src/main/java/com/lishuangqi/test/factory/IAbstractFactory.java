package com.lishuangqi.test.factory;

/**
 * Created by michael on 2019/4/29.
 */
public interface IAbstractFactory {
    /**
     *
     * @return
     */
    Vehicle getCar();

    /**
     *
     */
    IBreakFast getBreakFast();
}
