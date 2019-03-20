package com.coding.temp.service.impl;

import com.coding.temp.dao.TablesMapper;
import com.coding.temp.entity.Tables;
import com.coding.temp.service.TablesService;
import com.coding.temp.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
