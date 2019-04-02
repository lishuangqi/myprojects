package com.lishuangqi.rediscache;

import java.lang.annotation.*;

/**
 * @author lishuangqi
 * @version v1
 * @summary reids缓存注入Key
 * @Copyright
 * @since 2019/3/16
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisKey {

    /**
     * 用在model参数前时, 需指定用作key的字段名。
     * e.g keyField = {"filed1", "field2", "field3"}
     * @return
     */
    String[] keyField() default {};
}
