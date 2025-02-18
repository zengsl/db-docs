package com.zzz.dbdocs.api.service;

/**
 * 文档生成服务
 *
 * @author zengsl
 */
public interface DbDocsGenService {

    /**
     * 生成所有表文档
     *
     * @param dataSourceKey 数据源的key值 {@link DbDocsProperties#getDataSourceMap()}
     */
    void generateAllTableDocs(String dataSourceKey);

    /**
     * 生成指定表文档
     *
     * @param dataSourceKey 数据源的key值
     * @param tableName 表名
     */
    void generateTableDocs(String dataSourceKey, String tableName);
}
