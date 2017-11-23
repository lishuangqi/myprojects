package com.lishuangqi.cache.api;

/**
 * Created by michael on 2017/11/13.
 */

public class CacheServiceFactory {
    public CacheServiceFactory() {
    }

    public static CacheService getCacheService() {
        return getFactory().getCacheService();
    }

    public static CacheService getCacheService(String namespace) {
        return getFactory().getCacheService(namespace);
    }

    private static ICacheServiceFactory getFactory() {
        return (ICacheServiceFactory)ServiceFactoryFactory.getFactory(ICacheServiceFactory.class);
    }
}
