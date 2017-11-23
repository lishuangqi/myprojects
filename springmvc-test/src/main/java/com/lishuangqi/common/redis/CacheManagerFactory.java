package com.lishuangqi.common.redis;


import com.lishuangqi.cache.*;
import com.lishuangqi.cache.ehcache.EhcacheManager;
import com.lishuangqi.cache.redis.RedisManager;
import com.lishuangqi.cache.redis.RedisStringManager;
/**
 * Created by michael on 2017/11/13.
 */
public class CacheManagerFactory {
    private static ICaheManager redisManager;
    private static ICaheManager redisStringManager;
    private static ICaheManager aceCache;
    private static ICaheManager ehcacheManager;
    private static ICaheManager centralizedCacheManager;
    private static ICaheManager LocalCacheManager;

    public CacheManagerFactory() {
    }

    public static ICaheManager getCentralizedCacheManager() {
        if(centralizedCacheManager == null) {
            String centralizedCacheManagerClass = CacheManagerParam.getCentralizedCacheManagerClass();
            if(centralizedCacheManagerClass != null) {
                try {
                    Class e = Class.forName(centralizedCacheManagerClass);
                    if(e != null) {
                        Object instance = e.newInstance();
                        if(instance instanceof ICaheManager) {
                            centralizedCacheManager = (ICaheManager)instance;
                            centralizedCacheManager.init();
                        }
                    }
                } catch (Exception var3) {
                    var3.printStackTrace();
                }
            }
        }

        return centralizedCacheManager;
    }

    public static ICaheManager getLocalCacheManager() {
        if(LocalCacheManager == null) {
            String localCacheManagerClass = CacheManagerParam.getLocalCacheManagerClass();
            if(localCacheManagerClass != null) {
                try {
                    Class e = Class.forName(localCacheManagerClass);
                    if(e != null) {
                        Object instance = e.newInstance();
                        if(instance instanceof ICaheManager) {
                            LocalCacheManager = (ICaheManager)instance;
                            LocalCacheManager.init();
                        }
                    }
                } catch (Exception var3) {
                    var3.printStackTrace();
                }
            }
        }

        return LocalCacheManager;
    }

    protected static ICaheManager getRedisManager() {
        return getRedisManager(CacheConstants.getRedisConfigPath());
    }

    protected static ICaheManager getRedisManager(String configFile) {
        if(redisManager == null) {
            redisManager = new RedisManager();
            redisManager.init();
        }

        return redisManager;
    }

    public static ICaheManager getRedisStringManager() {
        if(redisStringManager == null) {
            redisStringManager = new RedisStringManager();
            redisStringManager.init();
        }

        return redisStringManager;
    }

    protected static ICaheManager getEhcacheManager() {
        return getEhcacheManager(CacheConstants.getEhcacheConfigPath());
    }

    protected static ICaheManager getEhcacheManager(String configFile) {
        if(ehcacheManager == null) {
            ehcacheManager = new EhcacheManager();
            ehcacheManager.init();
        }

        return ehcacheManager;
    }

    protected static ICaheManager getACEcacheManager() {
        if(aceCache == null) {
            aceCache = new ACECacheManager();
            aceCache.init();
        }

        return aceCache;
    }
}
