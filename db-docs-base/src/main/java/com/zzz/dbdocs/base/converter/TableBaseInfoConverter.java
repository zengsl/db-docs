package com.zzz.dbdocs.base.converter;

import com.zzz.dbdocs.base.model.bo.TableBaseInfoBO;
import com.zzz.dbdocs.base.model.bo.TableColumnInfoBO;
import com.zzz.dbdocs.base.model.bo.TableInfoBO;
import com.zzz.dbdocs.base.model.po.TableBaseInfoPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TableBaseInfoConverter {
    TableBaseInfoConverter INSTANCE = Mappers.getMapper(TableBaseInfoConverter.class);

    TableBaseInfoPO bo2po(TableBaseInfoBO bo);

    List<TableBaseInfoPO> bo2po(List<TableBaseInfoBO> bo);

    TableBaseInfoBO po2BaseInfoBo(TableBaseInfoPO po);

    @Mapping(target = "tableColumnInfoBOList", ignore = true)
    TableInfoBO po2TableInfoBo(TableBaseInfoPO po);

    @Mapping(target = "tableColumnInfoBOList", source = "tableColumnInfoBOS")
    TableInfoBO po2TableInfoBo(TableBaseInfoPO po, List<TableColumnInfoBO> tableColumnInfoBOS);

    List<TableBaseInfoBO> po2BaseInfoBo(List<TableBaseInfoPO> po);

}
