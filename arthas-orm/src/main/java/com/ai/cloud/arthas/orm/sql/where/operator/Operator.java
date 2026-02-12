package com.ai.cloud.arthas.orm.sql.where.operator;

import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:34
 * @description Operator
 */
public interface Operator {

    /**
     * 该操作对应的sql
     * @return sql string
     */
    String getPreparedSql(String column);

    /**
     * 该sql执行时param都有哪些
     * @return param list
     */
    List<Object> getParams();
}
