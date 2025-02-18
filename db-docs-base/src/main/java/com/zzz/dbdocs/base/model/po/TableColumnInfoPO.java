package com.zzz.dbdocs.base.model.po;

import lombok.Data;

/**
 * 数据库表列信息PO
 *
 * @author zengsl
 */
@Data
public class TableColumnInfoPO {

    private String columnName;

    private String comments;

    private String dataType;

    private String dataLength;

    private String nullable;

    private String dataDefault;

    private String keyType;
}
