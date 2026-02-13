package com.ai.cloud.arthas.orm.sql.where.operator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:35
 * @description MatchOperator
 */
@Slf4j
public class MatchOperator implements Operator {

    protected final Object value;

    public MatchOperator(Object value) {
        this.value = value;
    }

    @Override
    public String getPreparedSql(String column) {
        if (value == null) {
            return column + "is null";
        }
        if (value instanceof Collection) {
            return buildCollectionOperate(column);
        }
        if (value.getClass().isArray()) {
            return buildArrayOperate(column);
        }
        return column + "=?";
    }

    @Override
    public List<Object> getParams() {
        if (value == null) {
            return Collections.emptyList();
        }
        if (value instanceof Collection) {
            return getCollectionParams();
        }
        if (value.getClass().isArray()) {
            return getArrayParams();
        }
        return Collections.singletonList(value);
    }

    protected String buildCollectionOperate(String column) {
        Collection<?> coll = (Collection<?>) value;
        if (CollectionUtils.isEmpty(coll)) {
            log.error("Collection is empty: {}", coll);
            throw new IllegalArgumentException();
        }
        if (coll.size() == 1) {
            return column + "=?";
        }
        String str = StringUtils.repeat("?", ",", coll.size());
        return column + "(" + str + ")";
    }

    protected String buildArrayOperate(String column) {
        Object[] array = (Object[]) value;
        if (array.length == 0) {
            log.error("Array is empty: {}", array);
            throw new IllegalArgumentException();
        }
        if (array.length == 1) {
            return column + "=?";
        }
        String str = StringUtils.repeat("?", ",", array.length);
        return column + "(" + str + ")";
    }

    protected List<Object> getCollectionParams() {
        Collection<?> coll = (Collection<?>) value;
        if (CollectionUtils.isEmpty(coll)) {
            return Collections.emptyList();
        } else {
            return new ArrayList<>(coll);
        }
    }

    protected List<Object> getArrayParams() {
        Object[] array = (Object[]) value;
        if (array.length == 0) {
            return Collections.emptyList();
        } else {
            return Arrays.asList(array);
        }
    }
}
