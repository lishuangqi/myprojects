package com.lishuangqi.cache;

import com.lishuangqi.cache.api.CacheService;
import com.lishuangqi.cache.api.CacheServiceFactory;
import com.lishuangqi.utils.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/11/13.
 */
public class ACECacheManager implements ICaheManager {
    public CacheService cacheService = null;
    private String namespace = "wsbp_cache";

    public ACECacheManager() {
    }

    @Override
    public void init() {
        try {
            this.namespace = CacheManagerParam.getCacheName();
            this.cacheService = CacheServiceFactory.getCacheService(this.namespace);
        } catch (Exception var2) {
            Logger.error("getCacheService Exception", var2);
        }

    }

    public CacheService getCacheService() {
        if(this.cacheService == null) {
            this.init();
        }

        return this.cacheService;
    }

    @Override
    public void set(String key, Object value) {
        if(value instanceof Serializable) {
            this.getCacheService().put(key, (Serializable)value);
        } else {
            throw new RuntimeException(value.getClass() + " must implements Serializable interface");
        }
    }

    @Override
    public void set(String key, Object value, int expire) {
        if(value instanceof Serializable) {
            this.getCacheService().put(key, (Serializable)value, expire);
        } else {
            throw new RuntimeException(value.getClass() + " must implements Serializable interface");
        }
    }

    @Override
    public <T> T get(String key) {
        return (T) this.getCacheService().get(key);
    }

    @Override
    public List<String> getKeys() {
        throw new RuntimeException("ACE not support this method");
    }

    @Override
    public void remove(String key) {
        this.getCacheService().delete(key);
    }

    @Override
    public void removeAll(List<String> keys) {
        if(keys != null && keys.size() > 0) {
            this.getCacheService().deleteAll(keys);
        }

    }

    @Override
    public long expire(String key, int seconds) {
        Serializable serializable = this.getCacheService().get(key);
        if(serializable != null) {
            this.getCacheService().put(key, serializable, seconds);
        }

        return (long)seconds;
    }

    @Override
    public boolean exists(String key) {
        return this.getCacheService().get(key) != null;
    }

    @Override
    public void close() {
    }

    @Override
    public void setBatch(Map<String, Object> cacheMap) {
    }
}
