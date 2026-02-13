package com.ai.cloud.arthas.orm.sql;

import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-12 14:21
 * @description SqlAble
 */
public interface SqlAble {

    /**
     * 生成sql
     * @return sql string
     */
    String getPreparedSql();

    /**
     * 对应参数
     * @return 参数列表
     */
    List<Object> getParams();
}
