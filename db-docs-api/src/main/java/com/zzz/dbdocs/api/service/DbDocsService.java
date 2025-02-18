package com.zzz.dbdocs.api.service;

import com.zzz.dbdocs.base.model.bo.TableBaseInfoBO;
import com.zzz.dbdocs.base.model.bo.TableInfoBO;

import java.util.List;

public interface DbDocsService {

    List<TableBaseInfoBO> generateAllTableBaseInfo();

    List<TableInfoBO> generateAllTableInfo();

    List<TableInfoBO> generateTableInfo(String tableName);
}
