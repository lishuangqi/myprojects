package com.lishuangqi.lock;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 /**
 * @author shitiecheng
 * @version v1
 * @summary 分布式锁管理
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2018/6/10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(LockManager.class)
public @interface EnableLock {
}