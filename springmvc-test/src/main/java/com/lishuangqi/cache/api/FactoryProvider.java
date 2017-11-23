package com.lishuangqi.cache.api;

/**
 * Created by michael on 2017/11/13.
 */
public interface FactoryProvider<I> {
    Class<I> getBaseInterface();

    I getFactoryInstance();
}