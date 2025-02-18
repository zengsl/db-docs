package com.zzz.dbdocs.service.template;

import com.zzz.dbdocs.base.model.bo.TableInfoBO;

import java.util.List;

/**
 * 模版服务
 *
 * @author zengsl
 */
public interface TemplateService {

    void generateAllTableDocs(List<TableInfoBO> tableInfoBOList);
}
