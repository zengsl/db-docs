package com.zzz.dbdocs.base.model.bo;

import lombok.Data;

/**
 * 数据库表基础信息
 *
 * @author zengsl
 */
@Data
public class TableBaseInfoBO {

    private String tableName;

    private String tableComment;

}
