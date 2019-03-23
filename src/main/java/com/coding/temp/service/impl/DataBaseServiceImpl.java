package com.coding.temp.service.impl;

import com.coding.temp.dao.DataBaseMapper;
import com.coding.temp.entity.Connect;
import com.coding.temp.entity.DataBase;
import com.coding.temp.entity.Tables;
import com.coding.temp.service.ConnectService;
import com.coding.temp.service.DataBaseService;
import com.coding.temp.service.TablesService;
import com.coding.temp.service.base.BaseServiceImpl;
import com.coding.temp.utils.DBUtils;
import com.coding.temp.utils.Page;
import com.coding.temp.utils.StringUtil;
import com.sun.tools.javac.util.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class DataBaseServiceImpl extends BaseServiceImpl<DataBase> implements DataBaseService {
    @Autowired
    private DataBaseMapper dataBaseMapper;
    @Override
    public DataBaseMapper getNameSpace() {
        return dataBaseMapper;
    }

    @Autowired
    private ConnectService connectService;
    @Autowired
    private TablesService tablesService;

    @Override
    public DataBase selectByPrimarySearch(DataBase db) {
        return dataBaseMapper.selectByPrimarySearch(db);
    }

    @Override
    public Page<DataBase> selectPage(DataBase dataBase) {
        Page<DataBase> page = new Page<>(dataBaseMapper.selectPageCount(), dataBase.getPageSize(), dataBase.getPageNum());
        List<DataBase> result = dataBaseMapper.selectPageList(dataBase);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public Boolean createTables(Long id, Long userId) {
        try{
            DataBase dataBase = dataBaseMapper.selectByPrimaryKey(id);
            if(dataBase != null){
                Connect connect = connectService.selectByPrimaryKey(dataBase.getConnectId());
                DBUtils dbUtil = new DBUtils();
                List<Tables> tableList = dbUtil.getTables(connect, dataBase.getName());
                if (null != tableList && tableList.size() != 0) {
                    String dest = "";
                    String[] sources = null;
                    if (!StringUtils.isEmpty(dataBase.getDbPrefixSource())) {
                        sources = dataBase.getDbPrefixSource().split(";");
                    }
                    Iterator i$ = tableList.iterator();
                    while(i$.hasNext()) {
                        Tables table = (Tables)i$.next();
                        table.setDbId(dataBase.getId());
                        table.setUserId(dataBase.getUserId());
                        table.setObjectVariableName(StringUtil.javaStyle(table.getName()));
                        if (null != sources) {
                            String[] arr$ = sources;
                            int len = sources.length;
                            for(int i = 0; i < len; i++) {
                                String source = arr$[i];
                                if (table.getName().contains(source)) {
                                    table.setObjectVariableName(StringUtil.javaStyle(table.getName().replaceAll(source, dest)));
                                    break;
                                }
                            }
                        }
                        table.setObjectName(table.getObjectVariableName().substring(0, 1).toUpperCase() + table.getObjectVariableName().substring(1));
                        table.setNameSpace(table.getObjectVariableName());
                        table.setTableDesc(table.getTableDesc());
                        Tables tableSearch = tablesService.selectByPrimarySearch(table);
                        if (tableSearch == null) {
                            table.setCreateTime(new Date());
                            tablesService.insert(table);
                        } else {
                            table.setId(tableSearch.getId());
                            tablesService.updateByPrimaryKeySelective(table);
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
