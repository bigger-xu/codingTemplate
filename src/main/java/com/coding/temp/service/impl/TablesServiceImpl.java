package com.coding.temp.service.impl;

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
import com.coding.temp.utils.DBUtils;
import com.coding.temp.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
}
