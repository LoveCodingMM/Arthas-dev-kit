package com.ai.cloud.arthas.orm.core;

import com.ai.cloud.arthas.orm.base.TableDO;

import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-10 15:56
 * @description CreateDao
 */
public interface CreateDao <KEY, ENTITY extends TableDO<KEY>>{

    boolean create(ENTITY entity);

    int create(Collection<ENTITY> entities);

    int createOnDuplicateKey(Collection<ENTITY> entities, List<String> updateColumns);

    void insertIgnore(ENTITY entity);

    int insertIgnore(Collection<ENTITY> entities);
}
