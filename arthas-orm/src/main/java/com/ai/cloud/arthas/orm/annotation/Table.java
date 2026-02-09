package com.ai.cloud.arthas.orm.annotation;

import java.lang.annotation.*;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-09 16:27
 * @description Table
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {

    /**
     * 数据库库名
     * @return string
     */
    String db() default "";

    /**
     * 数据库表名, 无默认值
     * @return string
     */
    String name();

    /**
     * 主键名称, 默认id
     * @return string
     */
    String keyColumn() default "id";

    /**
     * 路由字段名字
     * @return string
     */
    String shardColumn() default "id";
}