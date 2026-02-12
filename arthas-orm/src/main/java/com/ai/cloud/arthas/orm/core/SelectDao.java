package com.ai.cloud.arthas.orm.core;

import com.ai.cloud.arthas.orm.base.TableDO;

import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-10 15:58
 * @description SelectDao
 */
public interface SelectDao <KEY, ENTITY extends TableDO<KEY>> {

    ENTITY get(KEY id);

    List<ENTITY> get(List<KEY> ids);

    ENTITY get(String column, Object value);
}
