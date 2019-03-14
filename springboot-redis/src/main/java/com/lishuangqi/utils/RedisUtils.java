/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.lishuangqi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-17 21:12
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;
    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;
    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations;
    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> setOperations;
    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;

    @Value("${spring.redis.cacheName:hl_wisesoft_cache}")
    private String cacheName;
    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;
    private static final Integer SUCCESS = 1;

    private String getKeyName(String key) {
        return cacheName + ":S:" + key;
    }

    public void set(String key, Object value, long expire) {
        valueOperations.set(getKeyName(key), toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(getKeyName(key));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(getKeyName(key));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public void sset(String key, Object obj, long expire) {
        setOperations.add(getKeyName(key), obj);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
    }

    //set
    public Set sget(String key, long expire) {
        Set value = (Set) setOperations.members(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public void sset(String key, Object obj) {
        sset(key, obj, DEFAULT_EXPIRE);
    }

    public Set sget(String key) {
        return sget(key, DEFAULT_EXPIRE);
    }
    //set

    //hash
    public void hset(String key, String field, Object value) {
        hashOperations.put(getKeyName(key), field, value);
    }

    public void hset(String key, String field, String value, long expire) {
        hashOperations.put(getKeyName(key), field, value);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
    }

    public String hget(String key, String field, long expire) {
        hashOperations.get(getKeyName(key), field);
        String value = (String) hashOperations.get(getKeyName(key), field);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public void hset(String key, Map map, long expire) {
        hashOperations.putAll(getKeyName(key), map);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
    }

    public Object hget(String key, String field) {
        Map value = (Map) hashOperations.entries(getKeyName(key));
        return value.get(field);
    }

    public Map hget(String key, long expire) {
        Map value = (Map) hashOperations.entries(getKeyName(key));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public void hset(String key, Map map) {
        hset(key, map, DEFAULT_EXPIRE);
    }

    public Map hget(String key) {
        return hget(key, DEFAULT_EXPIRE);
    }

    /**
     * 直接返回实例
     *
     * @param key
     * @param field
     * @param clz
     * @return T 空则为null
     */
    public <T> T hget(String key, String field, Class<T> clz) {
        try {
            Map map = (Map) hashOperations.entries(getKeyName(key));
            String value = (String) map.get(field);
            if (value != null) {
                return JSONObject.parseObject(value, clz);
            }
        } catch (Exception e) {
            System.out.println("jedis缓存错误");
        }
        return null;
    }

    public void hmset(String key, Map map) {
        hashOperations.putAll(getKeyName(key), map);
    }

    public Map hmget(String key) {
        return hget(key, DEFAULT_EXPIRE);
    }

    public boolean hexist(String key) {
        Map value = (Map) hashOperations.entries(getKeyName(key));
        if (value != null && value.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    //hash

    //list
    public void lset(String key, List list, long expire) {
        listOperations.leftPush(getKeyName(key), list);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
    }

    public List lget(String key, long expire) {
        List value = (List) listOperations.leftPop(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(getKeyName(key), expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public void lset(String key, List list) {
        lset(key, list, DEFAULT_EXPIRE);
    }

    public List lget(String key) {
        return lget(key, DEFAULT_EXPIRE);
    }
    //list


    private static final String LOCK_LUA_SCRIPT = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";
    /**
     * 获取锁
     *
     * @param lockKey
     * @param value
     * @param expireTime：单位-秒
     * @return
     */
    public boolean getLock(String lockKey, String value, int expireTime) {
        boolean ret = false;
        try {
//            String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";

            DefaultRedisScript<String> redisScript = new DefaultRedisScript<>(LOCK_LUA_SCRIPT, String.class);

            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey),value,expireTime);

            if(SUCCESS.equals(result)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    /**
     * 释放锁
     *
     * @param lockKey
     * @param value
     * @return
     */
    public boolean releaseLock(String lockKey, String value) {

//        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        RedisScript<String> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, String.class);

        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value);
        if (SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }
}
