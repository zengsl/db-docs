package com.zzz.dbdocs.dao.mapper;

import com.zzz.dbdocs.base.model.po.TableBaseInfoPO;
import com.zzz.dbdocs.base.model.po.TableColumnInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mysql数据库Mapper 用于查询表信息
 *
 * @author zengsl
 */
public interface MysqlDocsMapper {

    List<TableBaseInfoPO> queryAllTablesBaseInfo();

    List<TableBaseInfoPO> queryTableBaseInfoByUser(@Param("tableName") String tableName);

    List<TableColumnInfoPO> queryTableAllFieldByTableName(@Param("tableName") String tableName);
}
