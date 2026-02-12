package com.ai.cloud.arthas.orm.core.impl;

import com.ai.cloud.arthas.orm.base.TableDO;
import com.ai.cloud.arthas.orm.core.DeleteDao;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 10:49
 * @description DeleteDaoImpl
 */
public class DeleteDaoImpl <KEY, ENTITY extends TableDO<KEY>> implements DeleteDao<KEY, ENTITY> {

    @Override
    public boolean delete(KEY id) {
        return false;
    }

    @Override
    public int delete(String column, Object value) {
        return 0;
    }
}
