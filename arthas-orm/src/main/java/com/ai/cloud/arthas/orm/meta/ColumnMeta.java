package com.ai.cloud.arthas.orm.meta;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 14:32
 * @description ColumnMeta
 */
public class ColumnMeta {
    private final String name;
    private final TableMeta table;
    private final boolean modifiable;

    public ColumnMeta(String name, TableMeta table, boolean modifiable) {
        this.table = table;
        this.name = name.trim();
        this.modifiable = modifiable;
    }
}
