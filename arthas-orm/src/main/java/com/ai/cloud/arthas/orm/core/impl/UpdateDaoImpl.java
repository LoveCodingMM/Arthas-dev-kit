package com.ai.cloud.arthas.orm.core.impl;

import com.ai.cloud.arthas.orm.base.TableDO;
import com.ai.cloud.arthas.orm.core.UpdateDao;

import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-10 16:12
 * @description UpdateDaoImpl
 */
public class UpdateDaoImpl <KEY, ENTITY extends TableDO<KEY>> implements UpdateDao<KEY, ENTITY> {

    @Override
    public boolean update(ENTITY entity) {
        return false;
    }

    @Override
    public int update(List<ENTITY> entities) {
        return 0;
    }
}
