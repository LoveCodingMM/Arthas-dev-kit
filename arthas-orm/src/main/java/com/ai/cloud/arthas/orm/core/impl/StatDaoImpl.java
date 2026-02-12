package com.ai.cloud.arthas.orm.core.impl;

import com.ai.cloud.arthas.orm.base.TableDO;
import com.ai.cloud.arthas.orm.core.StatDao;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-10 16:12
 * @description StatDaoImpl
 */
public class StatDaoImpl <KEY, ENTITY extends TableDO<KEY>> implements StatDao<KEY, ENTITY> {

    @Override
    public int countAll() {
        return 0;
    }
}
