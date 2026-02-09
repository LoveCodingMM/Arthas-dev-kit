package com.ai.cloud.arthas.orm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-09 16:19
 * @description Column
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Column {

    /**
     *  数据库对应的字段名
     * @return string
     */
    String name() default "";

    /**
     * 该字段是否被修改
     * @return boolean
     */
    boolean modifiable() default false;

    // todo: convert column type
}
