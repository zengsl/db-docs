package com.zzz.dbdocs.service.generator;

import com.zzz.dbdocs.api.service.DbDocsGenService;
import com.zzz.dbdocs.service.DbDocsServiceApplicationTests;
import com.zzz.dbdocs.service.config.DbDocsAutoconfigure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DbDocsServiceApplicationTests.class)
@ActiveProfiles("ut")
class DbDocsGenServiceImplTest {

    @Autowired
    private DbDocsGenService dbDocsGenService;

    @Test
    void generateAllTableDocs() {
        this.dbDocsGenService.generateAllTableDocs("dm-test-1");
    }

    @Test
    void generateTableDocs() {
        this.dbDocsGenService.generateTableDocs("dm-test-1", "SYS_ROLE");
    }
}