package com.zzz.dbdocs.base.model.bo;

import lombok.Data;

/**
 * 数据库表列信息
 *
 * @author zengsl
 */
@Data
public class TableColumnInfoBO {

    private String tableName;

    private String columnName;

    private String comments;

    private String dataType;

    private String dataLength;

    private String nullable;

    private String dataDefault;

    private String keyType;
}
