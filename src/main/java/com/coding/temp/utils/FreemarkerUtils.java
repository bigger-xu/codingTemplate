package com.coding.temp.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-24
 */
public class FreemarkerUtils {

    public static Template getTemplate(String template) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        String templatePath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "static/ftl/";
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        Template temp = cfg.getTemplate(template);
        return temp;
    }
    public static String getOutPutPath(){
       return ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "static/output/";
    }
}
