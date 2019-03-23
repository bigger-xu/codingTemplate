package com.coding.temp.service;

import com.coding.temp.entity.DataBase;
import com.coding.temp.service.base.BaseService;
import com.coding.temp.utils.Page;

/**
 * 数据库业务层
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-20
 */
public interface DataBaseService extends BaseService<DataBase> {
    /**
     * 根据DB中的参数查询数据库
     * @param db
     * @return
     */
    DataBase selectByPrimarySearch(DataBase db);

    /**
     * 数据表分页
     * @param dataBase
     * @return
     */
    Page<DataBase> selectPage(DataBase dataBase);

    /**
     * 生成表结构
     * @param id
     * @param userId
     * @return
     */
    Boolean createTables(Long id, Long userId);
}
