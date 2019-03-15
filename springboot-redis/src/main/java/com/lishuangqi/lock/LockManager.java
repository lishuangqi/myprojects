package com.lishuangqi.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author shitiecheng
 * @version v1
 * @summary 分布式锁管理
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2018/6/10
 */
@Aspect
@Component
public class LockManager {
    private static Logger logger = LoggerFactory.getLogger(LockManager.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Around(value = "@annotation(lock)", argNames = "pjp, lock")
    public Object around(ProceedingJoinPoint pjp, Lock lock) throws Throwable {
        Class clazz = pjp.getTarget().getClass();
        String methodName = pjp.getSignature().getName();
        //获取参数
        Object[] args = pjp.getArgs();
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method m = ms.getMethod();

        String keyPrix = lock.keyPrex();
        if (keyPrix.equals("")) {
            keyPrix = clazz.getName()+ ":" + methodName + ":";
        }

        //分布式锁的key
        StringBuilder lockKey = new StringBuilder("lock:" + keyPrix);
        //获取加注解的方法参数的值
        Annotation[][] parameterAnnotations = m.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] annotations = parameterAnnotations[i];
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == LockKey.class) {
                    LockKey anno = (LockKey) annotation;
                    if (anno.keyField() != null && anno.keyField().length > 0) {
                        lockKey.append(genModelKey(args[i], anno.keyField()));
                    } else {
                        lockKey.append("_");
                        lockKey.append(args[i]);
                    }
                }
            }
        }

        RedisLock redisLock = new RedisLock(redisTemplate, lockKey.toString(), lock.lockTime(), lock.timetOut());
        Object result = null;
        try {
            // 获得锁
            if (redisLock.lock()) {
                try {
                    result = pjp.proceed();
                } catch (Exception e) {
                    throw e;
                } finally {
                    if (!redisLock.unlock()) {
                        logger.warn("释放分布式锁失败, key=" + lockKey.toString());
                    }
                }
            } else {
                throw new Exception("获取分布式锁失败, key=" + lockKey.toString());
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    private String genModelKey(Object model, String[] fields) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (String field : fields) {
            sb.append("_");
            try {
                sb.append(model.getClass().getMethod(buildGetMethod(field)).invoke(model));
            } catch (Exception e) {
                logger.error("redisLock error: keyField '{}' 不存在", field, e);
                throw e;
            }
        }
        return sb.toString();
    }

    private String buildGetMethod(String field) {
        StringBuilder sb = new StringBuilder("get");
        sb.append(Character.toUpperCase(field.charAt(0)));
        sb.append(field.substring(1, field.length()));
        return sb.toString();
    }

}
