package com.coding.temp.service.impl;

import com.coding.temp.dao.DataBaseMapper;
import com.coding.temp.entity.DataBase;
import com.coding.temp.service.DataBaseService;
import com.coding.temp.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
