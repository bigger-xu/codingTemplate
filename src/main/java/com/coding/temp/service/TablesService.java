package com.coding.temp.service;

import com.alibaba.fastjson.JSONObject;
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

    /**
     * 生成字段
     * @param id
     * @param userId
     * @return
     */
    Boolean createColumn(Long id, Long userId);

    /**
     * 生成表
     * @param id
     * @param userId
     * @return
     */
    JSONObject tableGenerate(Long id,Long userId);

    /**
     * 批量生成表
     * @param ids
     * @param userId
     * @return
     */
    JSONObject tableBatchGenerate(String ids, Long userId);
}
