package com.coding.temp.service;

import com.coding.temp.entity.Connect;
import com.coding.temp.service.base.BaseService;
import com.coding.temp.utils.Page;

/**
 * 数据库连接业务层
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-20
 */
public interface ConnectService extends BaseService<Connect> {

    /**
     * 查询分页
     * @param connect
     * @return
     */
    Page<Connect> selectPage(Connect connect);
}
