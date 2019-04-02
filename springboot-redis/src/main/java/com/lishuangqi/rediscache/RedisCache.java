package com.lishuangqi.rediscache;

import java.lang.annotation.*;

/**
 * @author lishuangqi
 * @version v1
 * @summary reids缓存注入
 * @Copyright
 * @since 2019/3/16
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {

    /**
     * 缓存续时间 单位秒
     * 默认60分钟
     * @return
     */
    int cacheTime() default 60*60;

    /**
     * redis锁的key前缀
     * 如果为空，则默认为类名+方法名
     * @return
     */
    String keyPrex() default "";

    /**
     * 超时时间 单位毫秒
     * @return
     */
    long timetOut() default 300L;

    /**
     * 默认开启缓存
     * @return
     */
    boolean isCache() default true;
}
