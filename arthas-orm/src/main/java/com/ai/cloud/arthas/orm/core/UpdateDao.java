package com.ai.cloud.arthas.orm.core;

import com.ai.cloud.arthas.orm.base.TableDO;

import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-10 15:59
 * @description UpdateDao
 */
public interface UpdateDao <KEY, ENTITY extends TableDO<KEY>> {

    boolean update(ENTITY entity);

    int update(List<ENTITY> entities);
}
