package com.ai.cloud.arthas.orm.core;

import com.ai.cloud.arthas.orm.base.TableDO;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-10 15:59
 * @description StatDao
 */
public interface StatDao <KEY, ENTITY extends TableDO<KEY>> {

    int countAll();
}
