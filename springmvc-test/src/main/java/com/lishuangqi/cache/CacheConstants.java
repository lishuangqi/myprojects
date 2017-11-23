package com.lishuangqi.cache;

/**
 * Created by michael on 2017/11/13.
 */
public class CacheConstants {
    public static final String REDIS_CONFIG_PATH = "/config/framework.properties";
    public static final String EHCACHE_CONFIG_PATH = "/config/framework/ehcache.xml";

    public CacheConstants() {
    }

    public static String getRedisConfigPath() {
        return "/config/framework.properties";
    }

    public static String getEhcacheConfigPath() {
        return "/config/framework/ehcache.xml";
    }
}