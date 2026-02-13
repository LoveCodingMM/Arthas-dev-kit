package com.ai.cloud.arthas.orm.sql.where.operator;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:45
 * @description FindInSetOperator
 */
public class FindInSetOperator implements Operator {
    private String str;

    public FindInSetOperator(String str) {
        this.str = str;
    }

    @Override
    public String getPreparedSql(String column) {
        return String.format("FIND_IN_SET(?, %s) > 0",  column);
    }

    @Override
    public List<Object> getParams() {
        return Collections.singletonList(str);
    }
}
