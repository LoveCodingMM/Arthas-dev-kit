package com.ai.cloud.arthas.orm.core.impl;

import com.ai.cloud.arthas.orm.base.TableDO;
import com.ai.cloud.arthas.orm.core.DataTable;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-10 16:13
 * @description DataTableImpl
 */
public class DataTableImpl <KEY, ENTITY extends TableDO<KEY>> implements DataTable<KEY, ENTITY> {

    protected JdbcTemplate jdbcTemplate;

    public DataTableImpl() {}

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

    }
}
