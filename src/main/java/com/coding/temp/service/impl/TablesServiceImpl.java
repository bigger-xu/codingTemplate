package com.coding.temp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.coding.temp.dao.TablesMapper;
import com.coding.temp.entity.Column;
import com.coding.temp.entity.Connect;
import com.coding.temp.entity.DataBase;
import com.coding.temp.entity.Tables;
import com.coding.temp.service.ColumnService;
import com.coding.temp.service.ConnectService;
import com.coding.temp.service.DataBaseService;
import com.coding.temp.service.TablesService;
import com.coding.temp.service.base.BaseServiceImpl;
import com.coding.temp.utils.*;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;

/**
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-20
 */
@Service
public class TablesServiceImpl extends BaseServiceImpl<Tables> implements TablesService {
    @Autowired
    private TablesMapper tablesMapper;

    @Override
    public TablesMapper getNameSpace() {
        return tablesMapper;
    }
    @Autowired
    private DataBaseService dataBaseService;
    @Autowired
    private ConnectService connectService;
    @Autowired
    private ColumnService columnService;

    @Override
    public Page<Tables> selectPage(Tables tables) {
        Page<Tables> page = new Page<>(tablesMapper.selectPageCount(tables), tables.getPageSize(), tables.getPageNum());
        List<Tables> result = tablesMapper.selectPageList(tables);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public Tables selectByPrimarySearch(Tables table) {
        return tablesMapper.selectByPrimarySearch(table);
    }

    @Override
    public Boolean createColumn(Long id, Long userId) {
        try{
            Tables tables = tablesMapper.selectByPrimaryKey(id);
            if(tables != null){
                DataBase dataBase = dataBaseService.selectByPrimaryKey(tables.getDbId());
                Connect connect = connectService.selectByPrimaryKey(dataBase.getConnectId());
                DBUtils dbUtil = new DBUtils();
                List<Column> columnList = dbUtil.getColumns(connect, dataBase.getName(), tables.getName());
                if (null != columnList && columnList.size() != 0) {
                    Iterator i$ = columnList.iterator();
                    while(i$.hasNext()) {
                        Column column = (Column)i$.next();
                        column.setUserId(userId);
                        column.setTableId(tables.getId());
                        column.setSearchFlag("1");
                        if(!StringUtils.isEmpty(column.getColumnsType()) && "varchar".equals(column.getColumnsType())){
                            column.setObjectType("String");
                            column.setPackageName("java.lang.String");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "int".equals(column.getColumnsType())){
                            column.setObjectType("Integer");
                            column.setPackageName("java.lang.Integer");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "bigint".equals(column.getColumnsType())){
                            column.setObjectType("Long");
                            column.setPackageName("java.lang.Long");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "datetime".equals(column.getColumnsType())){
                            column.setObjectType("Date");
                            column.setPackageName("java.util.Date");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "smallint".equals(column.getColumnsType())){
                            column.setObjectType("Integer");
                            column.setPackageName("java.lang.Integer");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "tinyint".equals(column.getColumnsType())){
                            column.setObjectType("Integer");
                            column.setPackageName("java.lang.Integer");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "decimal".equals(column.getColumnsType())){
                            column.setObjectType("BigDecimal");
                            column.setPackageName("java.math.BigDecimal");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "char".equals(column.getColumnsType())){
                            column.setObjectType("String");
                            column.setPackageName("java.lang.String");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "blob".equals(column.getColumnsType())){
                            column.setObjectType("String");
                            column.setPackageName("java.lang.String");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "text".equals(column.getColumnsType())){
                            column.setObjectType("String");
                            column.setPackageName("java.lang.String");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "longtext".equals(column.getColumnsType())){
                            column.setObjectType("String");
                            column.setPackageName("java.lang.String");
                        }else if(!StringUtils.isEmpty(column.getColumnsType()) && "double".equals(column.getColumnsType())){
                            column.setObjectType("Double");
                            column.setPackageName("java.lang.Double");
                        }else{
                            column.setObjectType("String");
                            column.setPackageName("java.lang.String");
                        }
                        if (null != column.getObjectType() && column.getObjectType().equals("Date")) {
                            column.setDisplayTypeCode("datetime");
                            column.setDisplayType("日期控件");
                        } else {
                            column.setDisplayTypeCode("text");
                            column.setDisplayType("单行文本框");
                        }
                        if (column.getAttrName().toLowerCase().equals("id")) {
                            column.setDisplayPositionCode("D");
                            column.setDisplayPosition("删除");
                        } else {
                            column.setDisplayPositionCode("C,U,R");
                            column.setDisplayPosition("添加,修改,列表");
                        }
                        column.setValidateTypeCode("required");
                        column.setValidateType("必填");
                        Column columnSearch = columnService.selectByPrimarySearch(column);
                        if (columnSearch == null) {
                            column.setCreateTime(new Date());
                            columnService.insert(column);
                        } else {
                            column.setId(columnSearch.getId());
                            columnService.updateByPrimaryKeySelective(column);
                        }
                    }
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public JSONObject tableGenerate(Long id, Long userId) {
        JSONObject result = new JSONObject();
        try{
            Long time = System.currentTimeMillis();
            Tables tables = tablesMapper.selectByPrimaryKey(id);
            DataBase dataBase = dataBaseService.selectByPrimaryKey(tables.getDbId());
            List<TemplateConfig> templateList = TemplateConfig.getTemplateConfig();
            for(TemplateConfig template : templateList){
                generate(dataBase,tables,userId,template,null,String.valueOf(time));
            }
            result.put("url",FreemarkerUtils.getOutPutPath() + time + "/");
            result.put("fileName",time + ".zip");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject tableBatchGenerate(String ids, Long userId) {
        JSONObject result = new JSONObject();
        try{
            Long time = System.currentTimeMillis();
            Tables search = new Tables();
            search.setIds(ids);
            search.setUserId(userId);
            List<Tables> tableList = tablesMapper.selectListByParams(search);
            DataBase dataBase = dataBaseService.selectByPrimaryKey(tableList.get(0).getDbId());
            List<TemplateConfig> templateList = TemplateConfig.getTemplateConfig();
            for(Tables tables : tableList){
                for(TemplateConfig template : templateList){
                    generate(dataBase,tables,userId,template,null,String.valueOf(time));
                }
            }
            result.put("url",FreemarkerUtils.getOutPutPath() + time + "/");
            result.put("fileName",time + ".zip");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private void generate(DataBase dataBase, Tables tables, Long userId, TemplateConfig template, List<Tables> tableList, String timeMillis) throws Exception {
        Column columnSearch = new Column();
        columnSearch.setTableId(tables.getId());
        List<Column> columnList = columnService.selectListByParams(columnSearch);
        if(columnList == null || columnList.size() < 1){
            return;
        }
        List<Column> updateColumnList = columnService.selectListByParams(columnSearch);
        List<String> importList = columnService.getPackageNameByTable(tables.getId());
        Map<String, Object> params = new HashMap();
        //暂时不要tablesName String packageName = dataBase.getNameSpace() + "." + tables.getNameSpace();
        String packageName = dataBase.getNameSpace();
        params.put("package", packageName);
        params.put("basePackage", dataBase.getNameSpace());
        params.put("objectName", tables.getObjectName());
        params.put("objectVariableName", tables.getObjectVariableName());
        params.put("author", userId);
        params.put("createTime", DateUtil.getNow());
        params.put("columnList", columnList);
        updateColumnList = getUpdateColumnList(updateColumnList);
        params.put("updateColumnList", updateColumnList);
        params.put("importList", importList);
        params.put("objectDes", tables.getTableDesc());
        params.put("tableName", tables.getName());
        params.put("columnListStr", this.getColumnAttrStr(columnList));
        if (null == tableList || tableList.size() == 0) {
            tableList = new ArrayList();
            tableList.add(tables);
        }
        params.put("tableList", tableList);

        String templateFile = template.getDir();
        String nameSpace = packageName.replaceAll("\\.", "\\/");
        String sourcePath = template.getCodeDir();
        if (sourcePath.contains("{nameSpace}")) {
            sourcePath = sourcePath.replaceAll("\\{nameSpace\\}", nameSpace);
        } else if (sourcePath.contains("{objectName}")) {
            sourcePath = sourcePath.replaceAll("\\{objectName\\}", tables.getObjectName());
        } else if (sourcePath.contains("{objectVarName}")) {
            sourcePath = sourcePath.replaceAll("\\{objectVarName\\}", tables.getObjectVariableName());
        }
        String fileStr = FreemarkerUtils.getOutPutPath() + timeMillis + "/" + sourcePath + "/" + this.getFileName(template.getNameRule(), tables.getObjectName(), tables.getObjectVariableName());
        this.build(templateFile, fileStr, params);
        params.clear();
    }

    private void build(String templateFilePath, String filePath, Map<String, Object> data) throws Exception {
        Template template = FreemarkerUtils.getTemplate(templateFilePath);
        File file = new File(filePath);
        File directory = file.getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }

        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        template.process(data, out);
        out.flush();
        out.close();
    }

    private String getColumnAttrStr(List<Column> list) {
        if (list != null && list.size() > 0) {
            List<String> attrList = new ArrayList();
            Iterator i$ = list.iterator();
            while(i$.hasNext()) {
                Column col = (Column)i$.next();
                attrList.add(col.getAttrVariableName());
            }
            return StringUtil.listToString(attrList);
        } else {
            return "";
        }
    }

    public List<Column> getUpdateColumnList(List<Column> updateColumnList) throws Exception {
        List<Column> newList = new ArrayList();
        if (updateColumnList != null && updateColumnList.size() > 0) {
            Iterator i$ = updateColumnList.iterator();

            while(i$.hasNext()) {
                Column column = (Column)i$.next();
                String attrName = column.getAttrVariableName();
                if (column != null && !StringUtils.isEmpty(attrName) && !"id".equals(attrName) && !"uuid".equals(attrName)) {
                    newList.add(column);
                }
            }
        }
        return newList;
    }

    private String getFileName(String nameRule, String objectName, String objectVariableName) {
        String fileName = nameRule;
        if (nameRule.contains("{objectName}")) {
            fileName = nameRule.replaceAll("\\{objectName\\}", objectName);
        } else if (nameRule.contains("{objectVarName}")) {
            fileName = nameRule.replaceAll("\\{objectVarName\\}", objectVariableName);
        }

        return fileName;
    }
}
