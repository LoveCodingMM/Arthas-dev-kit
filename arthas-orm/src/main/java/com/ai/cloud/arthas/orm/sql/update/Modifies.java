package com.ai.cloud.arthas.orm.sql.update;

import com.ai.cloud.arthas.orm.sql.Operate;
import com.ai.cloud.arthas.orm.sql.SqlAble;
import com.ai.cloud.arthas.orm.sql.update.setter.IncreaseSetter;
import com.ai.cloud.arthas.orm.sql.update.setter.NormalSetter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-14 23:33
 * @description Modifies
 */
public class Modifies implements SqlAble {
    private final List<Modify> operates = new ArrayList<>();

    private Modifies() {}

    public static Modifies init() {
        return new Modifies();
    }

    public Modifies one(String column, Object value) {
        return new Modifies().modify(column, value);
    }

    public Modifies increase(String column, Number value) {
        return new Modifies().increaseModify(column, value);
    }

    public Modifies modify(String column, Object value) {
        operates.add(new Modify(column, new NormalSetter(value)));
        return this;
    }

    public Modifies increaseModify(String column, Number value) {
        operates.add(new Modify(column, new IncreaseSetter(value)));
        return this;
    }

    @Override
    public String getPreparedSql() {
        return operates.stream()
                       .map(Operate::getPreparedSql)
                       .collect(Collectors.joining(","));
    }

    @Override
    public List<Object> getParams() {
        List<Object> params = new ArrayList<>(operates.size() * 2);
        for (Modify modify : operates) {
            params.addAll(modify.getParams());
        }
        return params;
    }
}
