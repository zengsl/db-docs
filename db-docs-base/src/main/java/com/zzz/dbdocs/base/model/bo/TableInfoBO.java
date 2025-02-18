package com.zzz.dbdocs.base.model.bo;

import lombok.Data;

import java.util.List;

/**
 * 数据库表信息 包含列
 *
 * @author zengsl
 */
@Data
public class TableInfoBO {

    private String tableName;

    private String tableComment;

    private List<TableColumnInfoBO> tableColumnInfoBOList;

}
