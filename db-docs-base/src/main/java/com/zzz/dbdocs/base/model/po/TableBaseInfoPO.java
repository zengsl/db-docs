package com.zzz.dbdocs.base.model.po;

import lombok.Data;

/**
 * 数据库表基础信息PO
 *
 * @author zengsl
 */
@Data
public class TableBaseInfoPO {

    private String tableName;

    private String tableComment;

}
