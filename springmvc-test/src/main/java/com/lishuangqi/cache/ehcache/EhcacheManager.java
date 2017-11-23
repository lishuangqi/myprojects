package com.lishuangqi.cache.ehcache;


import com.lishuangqi.cache.CacheManagerParam;
import com.lishuangqi.cache.ICaheManager;
import com.lishuangqi.utils.ConfigResource;
import com.lishuangqi.utils.Logger;
import com.lishuangqi.utils.ResourceUtils;
import com.lishuangqi.utils.SystemEnvUtil;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.ConfigurationFactory;
import net.sf.ehcache.config.DiskStoreConfiguration;

/**
 * Created by michael on 2017/11/13.
 */
public class EhcacheManager implements ICaheManager {
    public static CacheManager cacheManager;
    private String cacheConfig;
    private String cacheName = "wsbp_cache";
    private Boolean isflush = Boolean.valueOf(false);

    public EhcacheManager() {
    }

    @Override
    public void init() {
        try {
            this.cacheConfig = ConfigResource.getResourcePath("ehcache.xml");
            System.out.println("useing ehcache:" + this.cacheConfig);
            FileInputStream e = new FileInputStream(ResourceUtils.getFile(this.cacheConfig));
            if(cacheManager == null && e != null) {
                Configuration configuration = ConfigurationFactory.parseConfiguration(e);
                if(configuration != null && configuration.getDiskStoreConfiguration() != null) {
                    DiskStoreConfiguration storeConfiguration = configuration.getDiskStoreConfiguration();
                    String path = storeConfiguration.getPath();
                    path = SystemEnvUtil.replace(path);
                    configuration.getDiskStoreConfiguration().setPath(path);
                }

                cacheManager = CacheManager.create(configuration);
            }

            this.cacheName = CacheManagerParam.getCacheName();
            this.isflush = Boolean.valueOf(CacheManagerParam.getEhCacheIsflush());
        } catch (Exception var5) {
            Logger.info("using default cacheConfig");
            cacheManager = CacheManager.create();
        }

    }

    public CacheManager getCacheManager() {
        if(cacheManager == null) {
            this.init();
        }

        return cacheManager;
    }

    public Cache getOrAddCache(String cacheName) {
        Cache cache = this.getCacheManager().getCache(cacheName);
        if(cache == null) {
            synchronized(this.getCacheManager()) {
                cache = this.getCacheManager().getCache(cacheName);
                if(cache == null) {
                    Logger.info("Could not find cache config [" + cacheName + "], using default config create.");
                    this.getCacheManager().addCacheIfAbsent(cacheName);
                    cache = this.getCacheManager().getCache(cacheName);
                    Logger.info("Cache [" + cacheName + "] start use.");
                }
            }
        }

        return cache;
    }

    @Override
    public void set(String key, Object value) {
        this.getOrAddCache(this.cacheName).put(new Element(key, value));
        if(this.isflush.booleanValue()) {
            this.getOrAddCache(this.cacheName).flush();
        }

    }

    @Override
    public void set(String key, Object value, int expire) {
        this.getOrAddCache(this.cacheName).put(new Element(key, value));
        this.flush();
    }

    @Override
    public <T> T get(String key) {
        Element element = this.getOrAddCache(this.cacheName).get(key);
        this.flush();
        return element != null? (T) element.getObjectValue() :null;
    }

    @Override
    public List<String> getKeys() {
        List keys = this.getOrAddCache(this.cacheName).getKeys();
        this.flush();
        return keys;
    }

    @Override
    public void remove(String key) {
        this.getOrAddCache(this.cacheName).remove(key);
        this.flush();
    }

    @Override
    public void removeAll(List<String> keys) {
        this.getOrAddCache(this.cacheName).removeAll();
        this.flush();
    }

    @Override
    public long expire(String key, int seconds) {
        return 0L;
    }

    @Override
    public boolean exists(String key) {
        Element element = this.getOrAddCache(this.cacheName).get(key);
        return element != null;
    }

    @Override
    public void close() {
        cacheManager.shutdown();
    }

    public void flush() {
        if(this.isflush.booleanValue()) {
            this.getOrAddCache(this.cacheName).flush();
        }

    }

    @Override
    public void setBatch(Map<String, Object> cacheMap) {
    }
}

