package com.zzz.dbdocs.service.generator;

import com.zzz.dbdocs.api.service.DbDocsDispatchService;
import com.zzz.dbdocs.api.service.DbDocsGenService;
import com.zzz.dbdocs.base.model.bo.TableInfoBO;
import com.zzz.dbdocs.service.template.TemplateService;
import lombok.RequiredArgsConstructor;

import java.util.List;
/**
 * 数据库文档生成服务
 *
 * @author zengsl
 */
@RequiredArgsConstructor
public class DbDocsGenServiceImpl implements DbDocsGenService {

    private final DbDocsDispatchService dbDocsDispatchService;
    private final TemplateService templateService;

    @Override
    public void generateAllTableDocs(String dataSourceKey) {
        List<TableInfoBO> tableInfoBOS = dbDocsDispatchService.generateAllTableInfo(dataSourceKey);
        // 生成文件
        templateService.generateAllTableDocs(tableInfoBOS);
    }

    @Override
    public void generateTableDocs(String dataSourceKey, String tableName) {
        List<TableInfoBO> tableInfoBOS = dbDocsDispatchService.generateTableInfo(dataSourceKey, tableName);
        templateService.generateAllTableDocs(tableInfoBOS);

    }
}
