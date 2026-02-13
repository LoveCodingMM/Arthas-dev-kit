package com.ai.cloud.arthas.orm.sql.where;

import com.ai.cloud.arthas.orm.sql.Operate;
import com.ai.cloud.arthas.orm.sql.where.operator.Operator;
import lombok.Getter;

import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:39
 * @description Match
 */
@Getter
public class Match implements Operate {
    private final String column;
    private final Operator operator;

    public Match(String column, Operator operator) {
        this.column = column;
        this.operator = operator;
    }

    @Override
    public String getPreparedSql() {
        return operator.getPreparedSql(column);
    }

    @Override
    public List<Object> getParams() {
        return operator.getParams();
    }
}
