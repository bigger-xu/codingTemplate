package com.coding.temp.dao;

import com.coding.temp.dao.base.BaseDao;
import com.coding.temp.entity.Column;
import org.springframework.stereotype.Repository;

/**
 * 字段
 * @author Zhang Yongwei
 * @date 2019-03-20
 * @version 1.0
 */
@Repository
public interface ColumnMapper  extends BaseDao<Column> {

    /**
     * 根据条件检索
     * @param column
     * @return
     */
    Column selectByPrimarySearch(Column column);
}