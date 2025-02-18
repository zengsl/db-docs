package com.zzz.dbdocs.service.config;

import com.zzz.dbdocs.base.model.bo.DataSourceInfo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * dbDocs属性对象
 *
 * @author zengsl
 */
@Data
@ConfigurationProperties(prefix = "db-docs")
public class DbDocsProperties {

    Map<String , DataSourceInfo> dataSourceMap;



}
