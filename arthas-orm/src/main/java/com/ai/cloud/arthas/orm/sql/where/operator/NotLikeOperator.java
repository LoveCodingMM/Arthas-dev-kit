package com.ai.cloud.arthas.orm.sql.where.operator;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:44
 * @description NotLikeOperator
 */
public class NotLikeOperator implements Operator {
    private final boolean leftStrict;
    private final boolean rightStrict;
    private final Object value;

    public NotLikeOperator(boolean leftStrict, boolean rightStrict, Object value) {
        this.leftStrict = leftStrict;
        this.rightStrict = rightStrict;
        this.value = value;
    }

    @Override
    public String getPreparedSql(String column) {
        return column + " not like ?";
    }

    @Override
    public List<Object> getParams() {
        String str = (leftStrict ? "" : "%") + value + (rightStrict ? "" : "%");
        return Collections.singletonList(str);
    }
}
