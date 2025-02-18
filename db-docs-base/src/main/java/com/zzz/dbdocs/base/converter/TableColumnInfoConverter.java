package com.zzz.dbdocs.base.converter;

import com.zzz.dbdocs.base.model.bo.TableColumnInfoBO;
import com.zzz.dbdocs.base.model.po.TableColumnInfoPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TableColumnInfoConverter {
    TableColumnInfoConverter INSTANCE = Mappers.getMapper(TableColumnInfoConverter.class);

   /* @Mapping(target = "tableName", ignore = true)
    TableColumnInfoBO po2bo(TableColumnInfoPO po);*/

    @Mapping(target = "tableName", source = "tableName")
    TableColumnInfoBO po2bo(String tableName, TableColumnInfoPO po);

    default List<TableColumnInfoBO> po2bo(String tableName, List<TableColumnInfoPO> po) {
        if (po == null) {
            return null;
        }

        List<TableColumnInfoBO> list = new ArrayList<>(po.size());
        for (TableColumnInfoPO tableColumnInfoPO : po) {
            list.add(po2bo(tableName, tableColumnInfoPO));
        }

        return list;
    }

}
