package com.ai.cloud.arthas.orm.mapper.column;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 15:41
 * @description BasicColumnMapper
 */
@Setter
@Getter
public class BasicColumnMapper<JavaType, ENTITY> implements ColumnMapper<JavaType, ENTITY> {

    private final Field field;
    private final String column;

    public BasicColumnMapper(Field field, String column, Class<JavaType> type) {
        this.field = field;
        this.column = column.trim();
    }

    @Override
    public void localColumn2Field(ResultSet rs, ENTITY entity) throws SQLException, IllegalAccessException {

    }

    @Override
    public JavaType getColumnValue(ENTITY entity) {
        return null;
    }
}
