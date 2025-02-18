package com.zzz.dbdocs.service.dbhandler;

import com.zzz.dbdocs.api.service.DbDocsService;
import com.zzz.dbdocs.base.converter.TableBaseInfoConverter;
import com.zzz.dbdocs.base.converter.TableColumnInfoConverter;
import com.zzz.dbdocs.base.model.bo.TableBaseInfoBO;
import com.zzz.dbdocs.base.model.bo.TableColumnInfoBO;
import com.zzz.dbdocs.base.model.bo.TableInfoBO;
import com.zzz.dbdocs.base.model.po.TableBaseInfoPO;
import com.zzz.dbdocs.base.model.po.TableColumnInfoPO;
import com.zzz.dbdocs.dao.mapper.DmDocsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 达梦数据库处理对象
 *
 * @author zengsl
 */
@Service("dmDocsService")
public class DmDocsServiceImpl implements DbDocsService {

    @Autowired
    private DmDocsMapper dmDocsMapper;

    @Override
    public List<TableInfoBO> generateAllTableInfo() {
        List<TableBaseInfoPO> tableBaseInfoPOS = dmDocsMapper.queryAllTablesBaseInfo();
        return fillColumnAndbuildTableInfo(tableBaseInfoPOS);
    }

    @Override
    public List<TableInfoBO> generateTableInfo(String tableName) {
        List<TableBaseInfoPO> tableBaseInfoPOS = dmDocsMapper.queryTableBaseInfoByUser(tableName);
        return fillColumnAndbuildTableInfo(tableBaseInfoPOS);
    }

    private List<TableInfoBO> fillColumnAndbuildTableInfo(List<TableBaseInfoPO> tableBaseInfoPOS) {
        List<TableInfoBO> tableInfoBOList = new ArrayList<>(tableBaseInfoPOS.size());
        for (TableBaseInfoPO tableBaseInfoPO : tableBaseInfoPOS) {
            List<TableColumnInfoPO> tableColumnInfoPOS = dmDocsMapper.queryTableAllFieldByTableName(tableBaseInfoPO.getTableName());
            List<TableColumnInfoBO> tableColumnInfoBOS = TableColumnInfoConverter.INSTANCE.po2bo(tableBaseInfoPO.getTableName(), tableColumnInfoPOS);
            TableInfoBO tableInfoBO = TableBaseInfoConverter.INSTANCE.po2TableInfoBo(tableBaseInfoPO);
            tableInfoBO.setTableColumnInfoBOList(tableColumnInfoBOS);
            tableInfoBOList.add(tableInfoBO);
        }
        return tableInfoBOList;
    }

    @Override
    public List<TableBaseInfoBO> generateAllTableBaseInfo() {
        List<TableBaseInfoPO> tableBaseInfoPOS = dmDocsMapper.queryAllTablesBaseInfo();
        return TableBaseInfoConverter.INSTANCE.po2BaseInfoBo(tableBaseInfoPOS);
    }


}
