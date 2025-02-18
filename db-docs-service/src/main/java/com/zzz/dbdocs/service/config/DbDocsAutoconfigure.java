package com.zzz.dbdocs.service.config;

import com.zzz.dbdocs.api.service.DbDocsDispatchService;
import com.zzz.dbdocs.base.model.bo.DataSourceInfo;
import com.zzz.dbdocs.service.datasource.DataSourceHelper;
import com.zzz.dbdocs.service.datasource.DynamicDataSource;
import com.zzz.dbdocs.service.dispatcher.DbDocsDispatchServiceImpl;
import com.zzz.dbdocs.service.generator.DbDocsGenServiceImpl;
import com.zzz.dbdocs.service.template.TemplateService;
import com.zzz.dbdocs.service.template.impl.FreemarkerServiceImpl;
import com.zzz.dbdocs.service.utils.SpringUtils;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;


/**
 * dbDocs自动配置类
 *
 * @author zengsl
 */
@AutoConfiguration
@ComponentScan("com.zzz.dbdocs.service.dbhandler")
@EnableConfigurationProperties({DbDocsProperties.class, TemplateProperties.class})
public class DbDocsAutoconfigure {

    @Bean
    public DbDocsDispatchServiceImpl dbDocsService(DataSourceHelper dataSourceHelper) {
        return new DbDocsDispatchServiceImpl(dataSourceHelper);
    }

    @Bean
    public SpringUtils springUtils() {
        return new SpringUtils();
    }

    @Bean
    public FreemarkerServiceImpl templateService(TemplateProperties templateProperties) {
        return new FreemarkerServiceImpl(templateProperties);
    }

    @Bean
    public DbDocsGenServiceImpl dbDocsGenService(DbDocsDispatchService dbDocsDispatchService, TemplateService templateService) {
        return new DbDocsGenServiceImpl(dbDocsDispatchService, templateService);
    }

    @Bean
    public DataSource dataSource(DbDocsProperties dbDocsProperties) {
        AtomicReference<DriverManagerDataSource> defaultDataSource = new AtomicReference<>();
        final Map<Object, Object> targetDataSources = new HashMap<>();
        Map<String, DataSourceInfo> dataSourceMap = dbDocsProperties.getDataSourceMap();
        Assert.notNull(dataSourceMap, "数据源不能为空");
        dataSourceMap.forEach((key, value) -> {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(value.getDriverClassName());
            dataSource.setUrl(value.getUrl());
            dataSource.setUsername(value.getUsername());
            dataSource.setPassword(value.getPassword());
            if (defaultDataSource.get() == null) {
                defaultDataSource.set(dataSource);
            }
            targetDataSources.put(key, dataSource);
        });
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        // 设置默认数据源——项目信息存储的数据源
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource.get());
        return dynamicDataSource;
    }

    @Bean
    public DataSourceHelper dataSourceHelper(DbDocsProperties dbDocsProperties) {
        Map<String, DataSourceInfo> dataSourceMap = dbDocsProperties.getDataSourceMap();
        Assert.notNull(dataSourceMap, "数据源不能为空");
        final Map<String, String> dbTypeMapping = new HashMap<>();
        dataSourceMap.forEach((key, value) -> {
            dbTypeMapping.put(key, value.getDbType());
        });
        return new DataSourceHelper(dbTypeMapping);
    }
}
