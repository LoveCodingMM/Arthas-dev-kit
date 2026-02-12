package com.ai.cloud.arthas.orm.mapper.column;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 15:27
 * @description ColumnMapper
 */
public interface ColumnMapper <DbValue, ENTITY> {

    String getColumn();

    void localColumn2Field(ResultSet rs, ENTITY entity) throws SQLException, InvocationTargetException, IllegalAccessException;

    /**
     * 获取写入db的值
     * @param entity 属性实体
     * @return 写入db的值
     */
    DbValue getColumnValue(ENTITY entity);
}
