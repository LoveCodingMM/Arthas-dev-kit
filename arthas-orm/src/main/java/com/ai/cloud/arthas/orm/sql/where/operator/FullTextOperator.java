package com.ai.cloud.arthas.orm.sql.where.operator;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:45
 * @description FullTextOperator
 */
public class FullTextOperator implements Operator {

    private final Object value;

    public FullTextOperator(Object value) {
        this.value = value;
    }

    @Override
    public String getPreparedSql(String column) {
        return "MATCH (" + column + ") AGAINST (?)";
    }

    @Override
    public List<Object> getParams() {
        return Collections.singletonList(value);
    }
}
