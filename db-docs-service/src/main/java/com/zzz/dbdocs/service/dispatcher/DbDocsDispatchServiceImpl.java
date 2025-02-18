package com.zzz.dbdocs.service.dispatcher;

import com.zzz.dbdocs.api.service.DbDocsDispatchService;
import com.zzz.dbdocs.api.service.DbDocsService;
import com.zzz.dbdocs.base.enums.DbType;
import com.zzz.dbdocs.base.model.bo.TableInfoBO;
import com.zzz.dbdocs.service.datasource.DataSourceContextHolder;
import com.zzz.dbdocs.service.datasource.DataSourceHelper;
import com.zzz.dbdocs.service.utils.SpringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

import java.util.List;
/**
 * 数据库文档分发服务
 *
 * @author zengsl
 */
@RequiredArgsConstructor
public class DbDocsDispatchServiceImpl implements DbDocsDispatchService {

    private final DataSourceHelper dataSourceHelper;

    @Override
    public List<TableInfoBO> generateAllTableInfo(String dataSourceKey) {
        DbType dbType = dataSourceHelper.getDbType(dataSourceKey);
        Assert.notNull(dbType, "数据库类型不能为空，请检查platform配置");
        // 设置数据源信息
        DataSourceContextHolder.setDataSourceKey(dataSourceKey);
        // 获取数据库类型信息
        return SpringUtils.getBean(dbType.getHandlerBeanName(), DbDocsService.class).generateAllTableInfo();
    }

    @Override
    public List<TableInfoBO> generateTableInfo(String dataSourceKey, String tableName) {
        DbType dbType = dataSourceHelper.getDbType(dataSourceKey);
        Assert.notNull(dbType, "数据库类型不能为空，请检查platform配置");
        // 设置数据源信息
        DataSourceContextHolder.setDataSourceKey(dataSourceKey);
        // 获取数据库类型信息
        return SpringUtils.getBean(dbType.getHandlerBeanName(), DbDocsService.class).generateTableInfo(tableName);
    }
}
