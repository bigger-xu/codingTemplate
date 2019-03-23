package com.coding.temp.service.impl;

import com.coding.temp.dao.TablesMapper;
import com.coding.temp.entity.Tables;
import com.coding.temp.service.TablesService;
import com.coding.temp.service.base.BaseServiceImpl;
import com.coding.temp.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
