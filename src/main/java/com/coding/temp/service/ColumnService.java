package com.coding.temp.service;

import com.coding.temp.entity.Column;
import com.coding.temp.service.base.BaseService;
import com.coding.temp.utils.Page;

/**
 * 日志业务层
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-20
 */
public interface ColumnService extends BaseService<Column> {
    /**
     * 字段分页数据
     * @param column
     * @return
     */
    Page<Column> selectPage(Column column);

    /**
     * 根据条件检索
     * @param column
     * @return
     */
    Column selectByPrimarySearch(Column column);
}
