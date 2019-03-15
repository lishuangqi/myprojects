package com.lishuangqi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by michael on 2019/3/15.
 */
@Component
public class DistributedLock {
    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${spring.redis.cacheName:test_cache}")
    private String cacheName;
    private static final Long SUCCESS = 1L;

    private static final String LOCK_LUA_SCRIPT = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";
    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    private String getKeyName(String key) {
        return cacheName + ":S:" + key;
    }
    /**
     * 获取锁
     *
     * @param lockKey
     * @param value
     * @param expireTime：单位-秒
     * @return
     */
    public boolean getLock(String lockKey, String value, int expireTime) {
        lockKey = getKeyName(lockKey);
        boolean ret = false;
        try {
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
//            redisScript.setScriptText("if (redis.call('exists', KEYS[1]) == 0) then redis.call('hset', KEYS[1],ARGV[1], 1); " +
//                    "redis.call('pexpire', KEYS[1], ARGV[2]); return nil; end; " +
//                    "if (redis.call('hexists', KEYS[1], ARGV[1]) == 1) then redis.call('hincrby', KEYS[1], ARGV[1], 1); " +
//                    "redis.call('pexpire', KEYS[1], ARGV[2]); return nil; end; return redis.call('pttl', KEYS[1]);");
            redisScript.setScriptText(LOCK_LUA_SCRIPT);
            redisScript.setResultType(Long.class);

            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey),value,expireTime);

            if(SUCCESS.equals(result)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }


    /**
     * 释放锁
     *
     * @param lockKey
     * @param value
     * @return
     */
    public boolean releaseLock(String lockKey, String value) {
        lockKey = getKeyName(lockKey);
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
//        redisScript.setScriptText("if (redis.call('exists', KEYS[1]) == 0) then return 0; end; " +
//                "if (redis.call('hexists', KEYS[1], ARGV[1]) == 0) then return 0; end; " +
//                "local counter = redis.call('hincrby', KEYS[1], ARGV[1], -1); " +
//                "if (counter > 0) then return 1; " +
//                "else " +
//                "redis.call('del', KEYS[1]); return 1; end;");
        redisScript.setScriptText(RELEASE_LOCK_LUA_SCRIPT);
        redisScript.setResultType(Long.class);

        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value);
        if (SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }
}
