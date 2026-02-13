package com.ai.cloud.arthas.orm.sql.where;

import com.ai.cloud.arthas.orm.sql.Operate;
import com.ai.cloud.arthas.orm.sql.SqlAble;
import com.ai.cloud.arthas.orm.sql.where.operator.FindInSetOperator;
import com.ai.cloud.arthas.orm.sql.where.operator.MatchOperator;
import com.ai.cloud.arthas.orm.sql.where.operator.NotMatchOperator;
import com.ai.cloud.arthas.orm.sql.where.operator.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:39
 * @description Matches
 */
public class Matches implements Operate {
    private final static String AND = " and";
    private final static String OR = " or";

    private final String conj;
    private final List<Operate> operates = new ArrayList<>(2);
    private Matches(String conj) {
        this.conj = conj;
    }

    /**
     * @return Matches对象，空匹配集合
     */
    public static Matches empty() {
        return and();
    }

    /**
     * @return Matches对象，以and为连接符的匹配集
     */
    public static Matches and() {
        return new Matches(AND);
    }

    /**
     * @return Matches对象，以or为连接符的匹配集
     */
    public static Matches or() {
        return new Matches(OR);
    }

    public Matches match(String column, Object value) {
        operates.add(new Match(column, new MatchOperator(value)));
        return this;
    }

    public Matches one(String column, Object value) {
        return Matches.and()
                      .match(column, value);
    }

    public Matches ne(String column, Object value) {
        operates.add(new Match(column, new NotMatchOperator(value)));
        return this;
    }

    public Matches findInSet(String column, String value) {
        operates.add(new Match(column, new FindInSetOperator(value)));
        return this;
    }

    @Override
    public String getPreparedSql() {
        if (isEmpty()) {
            return "";
        }
        return operates.stream()
                .map( operate -> {
                    if (operate instanceof Matches) {
                        return " ( " + operate.getPreparedSql() + " )";
                    } else {
                        return operate.getPreparedSql();
                    }
                })
                .collect(Collectors.joining(conj));
    }

    @Override
    public List<Object> getParams() {
        List<Object> params = new ArrayList<>(operates.size() * 2);
        for (SqlAble match : operates) {
            params.addAll(match.getParams());
        }
        return params;
    }

    public boolean isEmpty() {
        return operates.isEmpty();
    }

    @Override
    public String getColumn() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Operator getOperator() {
        throw new UnsupportedOperationException();
    }
}
