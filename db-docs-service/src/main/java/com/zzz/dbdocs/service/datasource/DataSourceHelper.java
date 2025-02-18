package com.zzz.dbdocs.service.datasource;

import com.zzz.dbdocs.base.enums.DbType;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * DataSource帮助类
 *
 * @author zengsl
 */
@RequiredArgsConstructor
public class DataSourceHelper {

    private final Map<String ,String> dbTypeMapping;

    public DbType getDbType(String connectName) {
        String s = dbTypeMapping.get(connectName);
        return DbType.getDbTypeByValue(s);
    }
}
