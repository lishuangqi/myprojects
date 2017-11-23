package com.lishuangqi.cache.api;

/**
 * Created by michael on 2017/11/13.
 */
public interface ICacheServiceFactory {
    CacheService getCacheService();

    CacheService getCacheService(String var1);
}
