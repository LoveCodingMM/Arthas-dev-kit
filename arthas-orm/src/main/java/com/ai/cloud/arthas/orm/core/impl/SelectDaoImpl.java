package com.ai.cloud.arthas.orm.core.impl;

import com.ai.cloud.arthas.orm.base.TableDO;
import com.ai.cloud.arthas.orm.core.SelectDao;

import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-10 16:11
 * @description SelectDaoImpl
 */
public class SelectDaoImpl <KEY, ENTITY extends TableDO<KEY>> implements SelectDao<KEY, ENTITY> {

    @Override
    public ENTITY get(KEY id) {
        return null;
    }

    @Override
    public List<ENTITY> get(List<KEY> ids) {
        return null;
    }

    @Override
    public ENTITY get(String column, Object value) {
        return null;
    }
}
