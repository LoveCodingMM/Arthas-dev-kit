package com.ai.cloud.arthas.orm.sql.where.operator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:35
 * @description BetweenOperator
 */
public class BetweenOperator implements Operator {
    private final Object start;
    private final Object end;

    public BetweenOperator(Object start, Object end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String getPreparedSql(String column) {
        if (start == null && end == null) {
            return "";
        }
        if (start != null && end != null) {
            return column + " between ? and ?";
        }
        if (start != null) {
            return column + "<=?";
        }
        return column + ">=?";
    }

    @Override
    public List<Object> getParams() {
        List<Object> params = new ArrayList<>();

        if (start != null) {
            params.add(start);
        }
        if (end != null) {
            params.add(end);
        }
        return params;
    }
}
