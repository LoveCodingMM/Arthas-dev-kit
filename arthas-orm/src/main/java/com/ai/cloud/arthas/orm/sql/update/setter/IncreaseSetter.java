package com.ai.cloud.arthas.orm.sql.update.setter;

import com.ai.cloud.arthas.orm.sql.where.operator.Operator;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-14 23:49
 * @description IncreaseSetter
 */
public class IncreaseSetter implements Operator {
    private final Number value;

    public IncreaseSetter(Number value) {
        this.value = value;
    }

    @Override
    public String getPreparedSql(String column) {
        return column + "=" + column + " +?";
    }

    @Override
    public List<Object> getParams() {
        return Collections.singletonList(value);
    }
}
