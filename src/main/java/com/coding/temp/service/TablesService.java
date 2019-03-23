package com.coding.temp.service;

import com.coding.temp.entity.Connect;
import com.coding.temp.entity.Tables;
import com.coding.temp.service.base.BaseService;
import com.coding.temp.utils.Page;

/**
 * 表业务层
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-20
 */
public interface TablesService extends BaseService<Tables> {
    /**
     * 数据表分页
     * @param tables
     * @return
     */
    Page<Tables> selectPage(Tables tables);

    /**
     * 根据对象检索
     * @param table
     * @return
     */
    Tables selectByPrimarySearch(Tables table);
}
