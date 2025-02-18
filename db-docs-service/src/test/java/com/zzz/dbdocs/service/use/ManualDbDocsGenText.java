package com.zzz.dbdocs.service.use;

import com.zzz.dbdocs.api.service.DbDocsGenService;
import com.zzz.dbdocs.service.DbDocsServiceApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * 用于手动执行生成文档
 *
 * @author zengsl
 */
@SpringBootTest(classes = DbDocsServiceApplicationTests.class)
@ActiveProfiles("mu")
class ManualDbDocsGenText {

    @Autowired
    private DbDocsGenService dbDocsGenService;

    @Test
    void generateAllTableDocs() {
        // dataSourceKey参数为所配置的dataSourceMap中的key值,不是数据源的name
        this.dbDocsGenService.generateAllTableDocs("dm-test-supv");
    }

    @Test
    void generateTableDocs() {
        this.dbDocsGenService.generateTableDocs("dm-test-supv", "SYS_ROLE");
    }
}