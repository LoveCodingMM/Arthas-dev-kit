package com.ai.cloud.arthas.orm.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-11 15:18
 * @description DbCache
 */
public class DbCache {
    private final Map<String, DbMeta> DB_MAP = new HashMap<>();

    public static DbMeta getOrRegisterDb(String dbName) {
        dbName = dbName.trim();
        DbMeta dbMeta = DB_MAP.get(dbName);
        if (dbMeta != null) {
            return dbMeta;
        }
        dbMeta = new DbMeta(dbName);
        DB_MAP.put(dbMeta);
        return dbMeta;
    }
}
