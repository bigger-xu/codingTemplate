package com.coding.temp.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-24
 */
public class TemplateConfig {
    private String dir;
    private String codeDir;
    private String nameRule;

    public static List<TemplateConfig> getTemplateConfig(){
        List<TemplateConfig> list = new ArrayList<>();
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setDir("entity.ftl");
        templateConfig.setCodeDir("594cto/src/main/java/{nameSpace}/entity");
        templateConfig.setNameRule("{objectName}.java");
        list.add(templateConfig);
        return list;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getCodeDir() {
        return codeDir;
    }

    public void setCodeDir(String codeDir) {
        this.codeDir = codeDir;
    }

    public String getNameRule() {
        return nameRule;
    }

    public void setNameRule(String nameRule) {
        this.nameRule = nameRule;
    }
}
