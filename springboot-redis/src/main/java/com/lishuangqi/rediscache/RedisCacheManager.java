package com.lishuangqi.rediscache;

import com.lishuangqi.utils.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author lishuangqi
 * @version v1
 * @summary reids缓存注入
 * @Copyright
 * @since 2019/3/16
 */
@Aspect
@Component
public class RedisCacheManager {
    private static Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

    @Autowired
    private RedisUtil redisUtil;

    private Random ran = new Random();

    @Around(value = "@annotation(redisCache)", argNames = "pjp, redisCache")
    public Object around(ProceedingJoinPoint pjp, RedisCache redisCache) throws Throwable {
        Class clazz = pjp.getTarget().getClass();
        String methodName = pjp.getSignature().getName();
        //获取参数
        Object[] args = pjp.getArgs();
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method m = ms.getMethod();

        String keyPrix = redisCache.keyPrex();
        if (keyPrix.equals("")) {
            keyPrix = clazz.getName()+ ":" + methodName + ":";
        }

        //缓存的key
        StringBuilder redisKey = new StringBuilder("redisKey:" + keyPrix);
        Object result = redisUtil.get(redisKey.toString());
        if(redisCache.isForceCache() || (redisCache.isCache() && result == null)){
            result = pjp.proceed();
            //获取加注解的方法参数的值
            Annotation[][] parameterAnnotations = m.getParameterAnnotations();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                Annotation[] annotations = parameterAnnotations[i];
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType() == RedisKey.class) {
                        RedisKey anno = (RedisKey) annotation;
                        if (anno.keyField() != null && anno.keyField().length > 0) {
                            redisKey.append(genModelKey(args[i], anno.keyField()));
                        } else {
                            redisKey.append("_");
                            redisKey.append(args[i]);
                        }
                    }
                }
            }
            redisUtil.set(redisKey.toString(), result, redisCache.cacheTime()+ran.nextInt(10) );
        } else if(!redisCache.isCache()){
            result = pjp.proceed();
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
