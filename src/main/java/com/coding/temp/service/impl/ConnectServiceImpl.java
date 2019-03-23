package com.coding.temp.service.impl;

import com.coding.temp.dao.ConnectMapper;
import com.coding.temp.entity.Connect;
import com.coding.temp.entity.DataBase;
import com.coding.temp.service.ConnectService;
import com.coding.temp.service.DataBaseService;
import com.coding.temp.service.base.BaseServiceImpl;
import com.coding.temp.utils.DBUtils;
import com.coding.temp.utils.Page;
import com.coding.temp.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
public class ConnectServiceImpl extends BaseServiceImpl<Connect> implements ConnectService {
    @Autowired
    private ConnectMapper connectMapper;
    @Override
    public ConnectMapper getNameSpace() {
        return connectMapper;
    }
    @Autowired
    private DataBaseService dataBaseService;

    @Override
    public Page<Connect> selectPage(Connect connect) {
        Page<Connect> page = new Page<>(connectMapper.selectPageCount(), connect.getPageSize(), connect.getPageNum());
        List<Connect> result = connectMapper.selectPageList(connect);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public Boolean createDateBase(Long id,Long userId) {
        try{
            Connect connect = connectMapper.selectByPrimaryKey(id);
            boolean result;
            DBUtils dbUtil = new DBUtils();
            result = dbUtil.validateConn(connect);
            if (result) {
                List<DataBase> dbList = dbUtil.getDataBases(connect);
                if (null != dbList && dbList.size() != 0) {
                    Iterator i$ = dbList.iterator();
                    while(i$.hasNext()) {
                        DataBase db = (DataBase)i$.next();
                        db.setCode(db.getName());
                        db.setName(db.getName());
                        db.setConnectId(connect.getId());
                        db.setUserId(userId);
                        db.setNameSpace("com." + StringUtil.javaStyle(db.getName()));
                        db.setDbDesc(db.getName());
                        DataBase dataBaseSearch = dataBaseService.selectByPrimarySearch(db);
                        if (dataBaseSearch == null) {
                            db.setCreateTime(new Date());
                            dataBaseService.insert(db);
                        } else {
                            db.setId(dataBaseSearch.getId());
                            dataBaseService.updateByPrimaryKeySelective(db);
                        }
                    }
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
