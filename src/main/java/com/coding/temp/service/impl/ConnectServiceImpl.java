package com.coding.temp.service.impl;

import com.coding.temp.dao.ConnectMapper;
import com.coding.temp.entity.Connect;
import com.coding.temp.service.ConnectService;
import com.coding.temp.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
