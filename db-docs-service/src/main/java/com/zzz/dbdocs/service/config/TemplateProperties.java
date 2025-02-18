package com.zzz.dbdocs.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * dbDocs模版属性对象
 *
 * @author zengsl
 */
@Data
@ConfigurationProperties(prefix = "db-docs.template")
public class TemplateProperties {
    private String path = "/templates";
    private String name = "dbDoc.ftl";
    private String outFilePath = "gen-docs";
    private String outFileName = "db.doc";
}
