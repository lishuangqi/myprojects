package com.lishuangqi.redisLock;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 /**
 * @author lishuangqi
 * @version v1
 * @summary 分布式锁管理
 * @Copyright
 * @since 2019/3/16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(LockManager.class)
public @interface EnableLock {
}