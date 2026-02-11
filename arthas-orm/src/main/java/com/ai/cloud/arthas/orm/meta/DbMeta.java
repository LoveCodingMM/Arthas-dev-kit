package com.ai.cloud.arthas.orm.meta;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 14:29
 * @description DbMeta
 */
@Getter
@Setter
public class DbMeta {
    private final String name;
    private final List<TableMeta> tables = new ArrayList<>();

    public DbMeta(String name) {
        this.name = name.trim();
    }

    public void add(TableMeta tableMeta) {
        tables.add(tableMeta);
    }
}
