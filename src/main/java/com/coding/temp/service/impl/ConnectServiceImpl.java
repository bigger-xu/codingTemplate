package com.coding.temp.service.impl;

import com.coding.temp.dao.ConnectMapper;
import com.coding.temp.entity.Connect;
import com.coding.temp.service.ConnectService;
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
public class ConnectServiceImpl extends BaseServiceImpl<Connect> implements ConnectService {
    @Autowired
    private ConnectMapper connectMapper;
    @Override
    public ConnectMapper getNameSpace() {
        return connectMapper;
    }

    @Override
    public Page<Connect> selectPage(Connect connect) {
        Page<Connect> page = new Page<>(connectMapper.selectPageCount(), connect.getPageSize(), connect.getPageNum());
        List<Connect> result = connectMapper.selectPageList(connect);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }
}
