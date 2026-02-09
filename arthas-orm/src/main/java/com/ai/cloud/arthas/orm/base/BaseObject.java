package com.ai.cloud.arthas.orm.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-09 16:47
 * @description BaseObject
 */

@Getter
@Setter
public class BaseObject<KEY> implements TableDO<KEY> {

    private KEY id;

    @Override
    public KEY primaryKey() {
        return id;
    }

    @Override
    public void updatePrimaryKey(KEY key) {
        this.id = key;
    }
}
