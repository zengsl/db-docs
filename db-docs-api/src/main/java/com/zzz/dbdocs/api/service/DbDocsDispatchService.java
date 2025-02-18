package com.zzz.dbdocs.api.service;

import com.zzz.dbdocs.base.model.bo.TableInfoBO;

import java.util.List;

public interface DbDocsDispatchService {

    List<TableInfoBO> generateAllTableInfo(String dataSourceKey);

    List<TableInfoBO> generateTableInfo(String dataSourceKey, String tableName);
}
