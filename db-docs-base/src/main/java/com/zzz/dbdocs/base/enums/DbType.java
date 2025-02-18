package com.zzz.dbdocs.base.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 数据库类型
 *
 * @author zengsl
 */
@RequiredArgsConstructor
@Getter
public enum DbType {

    DM("dm", "dmDocsService"),
    MYSQL("mysql", "mysqlDocsService");

    private final String value;
    private final String handlerBeanName;


    public static DbType getDbTypeByValue(String value) {
        DbType[] enumConstants = DbType.class.getEnumConstants();
        for (DbType enumConstant : enumConstants) {
            if (enumConstant.getValue().equals(value)) {
                return enumConstant;
            }
        }
        return null;
    }
}
