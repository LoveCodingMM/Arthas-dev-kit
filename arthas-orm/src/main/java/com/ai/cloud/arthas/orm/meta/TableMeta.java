package com.ai.cloud.arthas.orm.meta;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 14:29
 * @description TableMeta
 */
public class TableMeta {
    private final DbMeta db;
    private final String name;
    private final List<ColumnMeta> columns = new ArrayList<>();
    private final String keyColumn;
    private final String shardColumn;

    public TableMeta(DbMeta db, String name, String keyColumn, String shardColumn) {
        this.db = db;
        this.name = name.trim();
        this.keyColumn = keyColumn.trim();
        this.shardColumn = shardColumn.trim();
    }

    public void add(ColumnMeta columnMeta) {
        columns.add(columnMeta);
    }

    public String fullTableName() {
        if (StringUtils.isBlank(db.getName())) {
            return name;
        }
        return db.getName() + "." + name;
    }
}
