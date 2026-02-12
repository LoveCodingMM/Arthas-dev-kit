package com.ai.cloud.arthas.orm.mapper.column.handler;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 17:07
 * @description TypeHandler
 */
public interface TypeHandler <JavaType, SqlType> extends DbTypeHandler<JavaType> {

    /**
     * java对象转sql
     * @param javaValue java对象
     * @return 返回sql对象
     */
    String transfer2Sql(JavaType javaValue);

    default JavaType transferByBinlog(String value) {
        throw new UnsupportedOperationException();
    }
}
