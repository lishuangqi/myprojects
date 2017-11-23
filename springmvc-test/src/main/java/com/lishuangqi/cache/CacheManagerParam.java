package com.lishuangqi.cache;

import com.lishuangqi.utils.FrameworkProps;

/**
 * Created by michael on 2017/11/13.
 */

public class CacheManagerParam {
    public CacheManagerParam() {
    }

    public static String getCacheName() {
        return FrameworkProps.getProperty("cacheName");
    }

    public static boolean getEhCacheIsflush() {
        return FrameworkProps.getProperty("ehcache.isflush", false);
    }

    public static String getEhCacheShutdownHook() {
        return FrameworkProps.getProperty("ehcache.shutdownHook", "false");
    }

    public static String getCentralizedCacheManagerClass() {
        return FrameworkProps.getProperty("Centralized.cacheManager", "com.lishuangqi.cache.redis.RedisManager");
    }

    public static String getLocalCacheManagerClass() {
        return FrameworkProps.getProperty("local.cacheManager", "com.lishuangqi.cache.ehcache.EhcacheManager");
    }
}
