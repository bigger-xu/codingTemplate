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
        //entity
        templateConfig.setDir("entity.ftl");
        templateConfig.setCodeDir("594cto/src/main/java/{nameSpace}/entity");
        templateConfig.setNameRule("{objectName}.java");
        list.add(templateConfig);
        //controller
        TemplateConfig templateConfig1 = new TemplateConfig();
        templateConfig1.setDir("controller.ftl");
        templateConfig1.setCodeDir("594cto/src/main/java/{nameSpace}/controller");
        templateConfig1.setNameRule("{objectName}Controller.java");
        list.add(templateConfig1);
        //entityVo
        TemplateConfig templateConfig2 = new TemplateConfig();
        templateConfig2.setDir("entityVo.ftl");
        templateConfig2.setCodeDir("594cto/src/main/java/{nameSpace}/entity/vo");
        templateConfig2.setNameRule("{objectName}Vo.java");
        list.add(templateConfig2);
        //mapper
        TemplateConfig templateConfig3 = new TemplateConfig();
        templateConfig3.setDir("mapper.ftl");
        templateConfig3.setCodeDir("594cto/src/main/java/{nameSpace}/dao");
        templateConfig3.setNameRule("{objectName}Mapper.java");
        list.add(templateConfig3);
        //mapperExtendXml
        TemplateConfig templateConfig4 = new TemplateConfig();
        templateConfig4.setDir("mapperExtendXml.ftl");
        templateConfig4.setCodeDir("594cto/src/main/java/{nameSpace}/mybatis/mapper/extends");
        templateConfig4.setNameRule("{objectName}ExtendMapper.xml");
        list.add(templateConfig4);
        //mapperXml
        TemplateConfig templateConfig5 = new TemplateConfig();
        templateConfig5.setDir("mapperXml.ftl");
        templateConfig5.setCodeDir("594cto/src/main/java/{nameSpace}/mybatis/mapper");
        templateConfig5.setNameRule("{objectName}Mapper.xml");
        list.add(templateConfig5);
        //service
        TemplateConfig templateConfig6 = new TemplateConfig();
        templateConfig6.setDir("service.ftl");
        templateConfig6.setCodeDir("594cto/src/main/java/{nameSpace}/service");
        templateConfig6.setNameRule("{objectName}Service.java");
        list.add(templateConfig6);
        //serviceImpl
        TemplateConfig templateConfig7 = new TemplateConfig();
        templateConfig7.setDir("serviceImpl.ftl");
        templateConfig7.setCodeDir("594cto/src/main/java/{nameSpace}/service/impl");
        templateConfig7.setNameRule("{objectName}ServiceImpl.java");
        list.add(templateConfig7);
        //index jsp
        TemplateConfig templateConfig8 = new TemplateConfig();
        templateConfig8.setDir("index_ins_jsp.ftl");
        templateConfig8.setCodeDir("594cto/src/main/java/{nameSpace}/web/jsp/{objectVarName}");
        templateConfig8.setNameRule("index.html");
        list.add(templateConfig8);
        //add jsp
        TemplateConfig templateConfig9 = new TemplateConfig();
        templateConfig9.setDir("add_ins_jsp.ftl");
        templateConfig9.setCodeDir("594cto/src/main/java/{nameSpace}/web/jsp/{objectVarName}");
        templateConfig9.setNameRule("add.html");
        list.add(templateConfig9);
        //edit jsp
        TemplateConfig templateConfig10 = new TemplateConfig();
        templateConfig10.setDir("edit_ins_jsp.ftl");
        templateConfig10.setCodeDir("594cto/src/main/java/{nameSpace}/web/jsp/{objectVarName}");
        templateConfig10.setNameRule("edit.html");
        list.add(templateConfig10);
        //add js
        TemplateConfig templateConfig11 = new TemplateConfig();
        templateConfig11.setDir("add_ins_js.ftl");
        templateConfig11.setCodeDir("594cto/src/main/java/{nameSpace}/web/js/{objectVarName}");
        templateConfig11.setNameRule("add.js");
        list.add(templateConfig11);
        //index js
        TemplateConfig templateConfig12 = new TemplateConfig();
        templateConfig12.setDir("index_ins_js.ftl");
        templateConfig12.setCodeDir("594cto/src/main/java/{nameSpace}/web/js/{objectVarName}");
        templateConfig12.setNameRule("index.js");
        list.add(templateConfig12);
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
