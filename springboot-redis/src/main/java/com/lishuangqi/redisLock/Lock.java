package com.lishuangqi.redisLock;

import java.lang.annotation.*;

/**
 * @author lishuangqi
 * @version v1
 * @summary 方法分布式锁
 * @Copyright
 * @since 2019/3/16
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lock{

    /**
     * 锁持续时间 单位秒
     * 默认1分钟
     * @return
     */
    int lockTime() default 60;

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
}