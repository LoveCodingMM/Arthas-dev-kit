package com.ai.cloud.arthas.orm.mapper.column.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 17:03
 * @description DbTypeHandler
 */
public interface DbTypeHandler<JavaType> {

    /**
     * 从resultSet中获取第index字段的值
     * @param rs 数据库获取的结果集
     * @param index 字段索引
     * @return Java对象
     * @throws SQLException 异常
     */
    JavaType transfer2Java(ResultSet rs, int index) throws SQLException;

    /**
     * 从resultSet中获取指定label的值
     * @param rs 数据库获取的结果集
     * @param label 指定label
     * @return Java对象
     * @throws SQLException 异常
     */
    JavaType transfer2Java(ResultSet rs, String label) throws SQLException;
}
