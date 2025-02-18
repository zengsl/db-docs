package com.zzz.dbdocs.service.template.impl;

import com.zzz.dbdocs.base.model.bo.TableInfoBO;
import com.zzz.dbdocs.service.config.TemplateProperties;
import com.zzz.dbdocs.service.template.TemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Freemarker配置
 *
 * @author zengsl
 */
@Slf4j
@RequiredArgsConstructor
public class FreemarkerServiceImpl implements TemplateService {

    private final TemplateProperties templateProperties;

    @Override
    public void generateAllTableDocs(List<TableInfoBO> tableInfoBOList) {
        // 创建配置实例
        Configuration cfg = new Configuration(new Version("2.3.34"));
        // 设置模板文件所在的目录
        cfg.setClassForTemplateLoading(FreemarkerServiceImpl.class, templateProperties.getPath());
        // 设置字符集
        cfg.setDefaultEncoding("UTF-8");
        // 加载模板
        Template template = null;
        try {
            template = cfg.getTemplate(templateProperties.getName());
        } catch (IOException e) {
            log.error("【所有表文档】模版读取异常", e);
        }
        if (template == null) {
            log.warn("【所有表文档】模版读取异常，结束生成流程");
            return;
        }
        // 创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("tablesInfo", tableInfoBOList);

        // 准备输出文件
        File outputFile = new File(templateProperties.getOutFilePath(), templateProperties.getOutFileName());
        try (Writer fileWriter = new FileWriter(outputFile)) {
            // 合并数据模型与模板，并将结果写入到文件
            template.process(dataModel, fileWriter);
        } catch (TemplateException e) {
            log.error("【所有表文档】模版渲染异常", e);
        } catch (IOException e) {
            log.error("【所有表文档】IO异常", e);
        }
        log.info("【所有表文档】文件已成功生成: {}", outputFile.getAbsolutePath());
    }
}
