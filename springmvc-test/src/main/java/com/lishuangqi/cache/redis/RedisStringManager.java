package com.lishuangqi.cache.redis;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.BeanUtils;
import redis.clients.jedis.Jedis;
/**
 * Created by michael on 2017/11/13.
 */
public class RedisStringManager extends RedisManager {
    public RedisStringManager() {
    }

    public static Object cvt(Object value, Class<?> type) {
        if(value != null && value.getClass() != type) {
            value = ConvertUtils.convert(value, type);
        }

        return value;
    }

    @Override
    public void set(String key, Object value) {
        Jedis cache = null;

        try {
            cache = pool.getResource();
            cache.del(this.getKeyClassName(key));
            String e = "";
            if(BeanUtils.isSimpleProperty(value.getClass())) {
                e = cvt(value, String.class).toString();
            } else {
                e = JSON.toJSONString(value);
            }

            cache.set(this.getKeyName(key, value.getClass().getName()), e);
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
            cache.del(this.getKeyClassName(key));
            String e = "";
            if(BeanUtils.isSimpleProperty(value.getClass())) {
                e = cvt(value, String.class).toString();
            } else {
                e = JSON.toJSONString(value);
            }

            String skey = this.getKeyName(key, value.getClass().getName());
            cache.set(skey, e);
            cache.expire(skey, expire);
        } catch (Exception var10) {
            throw new WsbpException("Error occured when set data from Redis cache", var10);
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
                String e = cache.get(this.getKeyClassName(key));
                if(e != null) {
                    String strclass = this.getClassName(key);
                    if(BeanUtils.isSimpleProperty(Class.forName(strclass))) {
                        obj = cvt(e, Class.forName(this.getClassName(key)));
                    } else {
                        obj = JSON.parseObject(e, Class.forName(strclass));
                    }
                }
            } catch (Exception var9) {
                throw new WsbpException("Error occured when get data from Redis cache", var9);
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
            cache.del(this.getKeyClassName(key));
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
                cache.del(this.getKeyClassName(string));
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
            result = cache.expire(this.getKeyClassName(key), seconds).longValue();
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
            result = cache.exists(this.getKeyClassName(key)).booleanValue();
            e = result;
        } catch (Exception var8) {
            throw new WsbpException("Error occured when check redis exists", var8);
        } finally {
            pool.returnResourceObject(cache);
        }

        return e;
    }

    private String getKeyName(String key, String clazz) {
        return this.cacheName + ":S:" + key + ":" + clazz;
    }

    private String getKeyClassName(String key) {
        return this.cacheName + ":S:" + key + ":" + this.getClassName(key);
    }

    private String getClassName(String key) {
        String StrClassName = "";
        Jedis cache = null;

        try {
            cache = pool.getResource();
            ArrayList e = new ArrayList();
            e.addAll(cache.keys(this.cacheName + ":S:" + key + ":*"));
            if(e != null && e.size() > 0) {
                String strkeys = (String)e.get(0);
                StrClassName = strkeys.substring(strkeys.lastIndexOf(58) + 1);
            }
        } catch (Exception var9) {
            throw new WsbpException("Error occured when check redis exists", var9);
        } finally {
            pool.returnResourceObject(cache);
        }

        return StrClassName;
    }

    @Override
    public void close() {
    }
}
