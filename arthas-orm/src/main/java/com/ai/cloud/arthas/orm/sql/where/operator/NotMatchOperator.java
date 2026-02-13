package com.ai.cloud.arthas.orm.sql.where.operator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:43
 * @description NotMatchOperator
 */
@Slf4j
public class NotMatchOperator extends MatchOperator {

    public NotMatchOperator(Object value) {
        super(value);
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
        return column + "!=?";
    }
    /**
     * value是集合类如何处理
     */
    protected String buildCollectionOperate(String column) {
        Collection<?> coll = (Collection<?>) value;
        if (CollectionUtils.isEmpty(coll)) {
            log.error("集合:{}是空的", coll);
            throw new IllegalArgumentException();
        }

        if (coll.size() == 1) {
            return column + "!=?";
        }

        String str = StringUtils.repeat("?", ",", coll.size());
        return column + " not in (" + str + ")";
    }

    protected String buildArrayOperate(String column) {
        Object[] array = (Object[]) value;
        if (array.length == 0) {
            log.error("array:{}是空的", array);
            throw new IllegalArgumentException();
        }

        if (array.length == 1) {
            return column + "!=?";
        }

        String str = StringUtils.repeat("?", ",", array.length);
        return column + " not in (" + str + ")";
    }

}
