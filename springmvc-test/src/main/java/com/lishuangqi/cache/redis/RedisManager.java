package com.lishuangqi.cache.redis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lishuangqi.cache.CacheManagerParam;
import com.lishuangqi.cache.ICaheManager;
import com.lishuangqi.utils.CollectionUtil;
import com.lishuangqi.utils.FrameworkProps;
import com.lishuangqi.utils.SerializeObjUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
/**
 * Created by michael on 2017/11/13.
 */
public class RedisManager implements ICaheManager {
    protected static JedisPool pool;
    protected String cacheName = "wsbp_cache";

    public RedisManager() {
    }

    @Override
    public synchronized void init() {
        try {
            if(pool == null) {
                JedisPoolConfig e = new JedisPoolConfig();
                String host = FrameworkProps.getProperty("redis.host", "127.0.0.1");
                String password = FrameworkProps.getProperty("redis.password", (String)null);
                int port = FrameworkProps.getProperty("redis.port", 6379);
                int timeout = FrameworkProps.getProperty("redis.timeout", 2000);
                int database = FrameworkProps.getProperty("redis.database", 0);
                e.setBlockWhenExhausted(FrameworkProps.getProperty("redis.blockWhenExhausted", true));
                e.setMaxIdle(FrameworkProps.getProperty("redis.maxIdle", 10));
                e.setMinIdle(FrameworkProps.getProperty("redis.minIdle", 5));
                e.setMaxTotal(FrameworkProps.getProperty("redis.maxTotal", 10000));
                e.setMaxWaitMillis((long)FrameworkProps.getProperty("redis.maxWait", 100));
                e.setTestWhileIdle(FrameworkProps.getProperty("redis.testWhileIdle", false));
                e.setTestOnBorrow(FrameworkProps.getProperty("redis.testOnBorrow", true));
                e.setTestOnReturn(FrameworkProps.getProperty("redis.testOnReturn", false));
                e.setNumTestsPerEvictionRun(FrameworkProps.getProperty("redis.numTestsPerEvictionRun", 10));
                e.setMinEvictableIdleTimeMillis((long)FrameworkProps.getProperty("redis.minEvictableIdleTimeMillis", 1000));
                e.setSoftMinEvictableIdleTimeMillis((long)FrameworkProps.getProperty("redis.softMinEvictableIdleTimeMillis", 10));
                e.setTimeBetweenEvictionRunsMillis((long)FrameworkProps.getProperty("redis.timeBetweenEvictionRunsMillis", 10));
                e.setLifo(FrameworkProps.getProperty("redis.lifo", false));
                pool = new JedisPool(e, host, port, timeout, password, database);
                this.cacheName = CacheManagerParam.getCacheName();
            }

        } catch (Exception var7) {
            throw new WsbpException("Error occured when init Redis cache", var7);
        }
    }

    @Override
    public void set(String key, Object value) {
        Jedis cache = null;

        try {
            cache = pool.getResource();
            cache.set(this.getKeyName(key).getBytes(), SerializeObjUtil.serialize(value));
        } catch (Exception var8) {
            throw new WsbpException("Error occured when set data from Redis cache", var8);
        } finally {
            pool.returnResourceObject(cache);
        }

    }

    @Override
    public void set(String key, Object value, int expire) {
        Jedis cache = null;

        try {
            cache = pool.getResource();
            cache.setex(this.getKeyName(key).getBytes(), expire, SerializeObjUtil.serialize(value));
        } catch (Exception var9) {
            throw new WsbpException("Error occured when set data from Redis cache", var9);
        } finally {
            pool.returnResourceObject(cache);
        }

    }

    @Override
    public <T> T get(String key) {
        if(null == key) {
            return null;
        } else {
            Object obj = null;
            Jedis cache = null;

            try {
                cache = pool.getResource();
                byte[] e = cache.get(this.getKeyName(key).getBytes());
                if(e != null) {
                    obj = SerializeObjUtil.deserialize(e);
                }
            } catch (Exception var8) {
                throw new WsbpException("Error occured when get data from Redis cache", var8);
            } finally {
                pool.returnResourceObject(cache);
            }

            return (T) obj;
        }
    }

    @Override
    public List<String> getKeys() {
        ArrayList keys = new ArrayList();
        Jedis cache = null;

        try {
            cache = pool.getResource();
            keys.addAll(cache.keys(this.cacheName + ":*"));

            for(int e = 0; e < keys.size(); ++e) {
                keys.set(e, ((String)keys.get(e)).substring(this.cacheName.length() + 3));
            }

            ArrayList var9 = keys;
            return var9;
        } catch (Exception var7) {
            throw new WsbpException("Error occured when get getKeys from Redis cache", var7);
        } finally {
            pool.returnResourceObject(cache);
        }
    }

    @Override
    public void remove(String key) {
        Jedis cache = null;

        try {
            cache = pool.getResource();
            cache.del(this.getKeyName(key));
        } catch (Exception var7) {
            throw new WsbpException("Error occured when remove data from Redis cache", var7);
        } finally {
            pool.returnResourceObject(cache);
        }

    }

    @Override
    public void removeAll(List<String> keys) {
        Jedis cache = null;

        try {
            cache = pool.getResource();
            Iterator e = keys.iterator();

            while(e.hasNext()) {
                String string = (String)e.next();
                cache.del(this.getKeyName(string));
            }
        } catch (Exception var8) {
            throw new WsbpException("Error occured when removeAll data from Redis cache", var8);
        } finally {
            pool.returnResourceObject(cache);
        }

    }

    @Override
    public long expire(String key, int seconds) {
        long result = -10000L;
        Jedis cache = null;

        long e;
        try {
            cache = pool.getResource();
            result = cache.expire(this.getKeyName(key), seconds).longValue();
            e = result;
        } catch (Exception var11) {
            throw new WsbpException("Error occured when update redis expire", var11);
        } finally {
            pool.returnResourceObject(cache);
        }

        return e;
    }

    @Override
    public boolean exists(String key) {
        boolean result = false;
        Jedis cache = null;

        boolean e;
        try {
            cache = pool.getResource();
            result = cache.exists(this.getKeyName(key)).booleanValue();
            e = result;
        } catch (Exception var8) {
            throw new WsbpException("Error occured when check redis exists", var8);
        } finally {
            pool.returnResourceObject(cache);
        }

        return e;
    }

    @Override
    public void setBatch(Map<String, Object> cacheMap) {
        Jedis cache = null;

        try {
            if(!CollectionUtil.isEmpty(cacheMap)) {
                cache = pool.getResource();
                Pipeline e = cache.pipelined();
                Iterator i$ = cacheMap.entrySet().iterator();

                while(i$.hasNext()) {
                    Entry entry = (Entry)i$.next();
                    e.set(((String)entry.getKey()).getBytes(), String.valueOf(entry.getValue()).getBytes());
                }

                e.sync();
                return;
            }
        } catch (Exception var9) {
            throw new WsbpException("Error occured when check redis exists", var9);
        } finally {
            pool.returnResourceObject(cache);
        }

    }

    private String getKeyName(String key) {
        return this.cacheName + ":S:" + key;
    }

    @Override
    public void close() {
    }
}
