package com.ai.cloud.arthas.orm.base;
/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-09 16:44
 * @description TableDO
 */
public interface TableDO<KEY> {

    /**
     * 获取主键值
     * @return KEY
     */
    KEY primaryKey();

    /**
     * 更新主键值
     * @param 主键值
     */
    void updatePrimaryKey(KEY key);
}
