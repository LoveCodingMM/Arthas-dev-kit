package com.ai.cloud.arthas.orm.sql;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:26
 * @description Operate
 */
public interface Operate extends SqlAble {

    /**
     * 获取操作列名
     * @return string
     */
    String getColumn();

    /**
     * 获取操作符
     * @return 操作符对象
     */
    Operate getOperator();
}
