package com.coding.temp.service.impl;

import com.coding.temp.dao.ColumnMapper;
import com.coding.temp.entity.Column;
import com.coding.temp.entity.Connect;
import com.coding.temp.service.ColumnService;
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
public class ColumnServiceImpl extends BaseServiceImpl<Column> implements ColumnService {

    @Autowired
    private ColumnMapper columnMapper;
    @Override
    public ColumnMapper getNameSpace() {
        return columnMapper;
    }

    @Override
    public Page<Column> selectPage(Column column) {
        Page<Column> page = new Page<>(columnMapper.selectPageCount(column), column.getPageSize(), column.getPageNum());
        List<Column> result = columnMapper.selectPageList(column);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public Column selectByPrimarySearch(Column column) {
        return columnMapper.selectByPrimarySearch(column);
    }
}
