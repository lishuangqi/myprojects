package com.lishuangqi.lock;

import java.lang.annotation.*;

/**
 * @author shitiecheng
 * @version v1
 * @summary 方法分布式锁
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2018/6/10
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