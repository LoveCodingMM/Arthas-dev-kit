package com.ai.cloud.arthas.orm.sql.where.operator;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:44
 * @description GtOperator
 */
public class GtOperator implements Operator {
    private final Object floor;
    private final boolean withEqual;

    public GtOperator(Object floor, boolean withEqual) {
        this.floor = floor;
        this.withEqual = withEqual;
    }

    @Override
    public String getPreparedSql(String column) {
        return column + (withEqual ? " >= ?" : " > ?");
    }

    @Override
    public List<Object> getParams() {
        return Collections.singletonList(floor);
    }
}
