package com.lishuangqi.redisLock;

import java.lang.annotation.*;

/**
 * @author lishuangqi
 * @version v1
 * @summary 被注解参数会作为分布式锁的key的一部分 支持多个参数
 * @Copyright
 * @since 2019/3/16
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockKey {
    /**
     * 用在model参数前时, 需指定用作key的字段名。
     * e.g keyField = {"filed1", "field2", "field3"}
     * @return
     */
    String[] keyField() default {};
}