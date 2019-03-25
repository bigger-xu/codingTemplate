package com.coding.temp.dao;

import com.coding.temp.dao.base.BaseDao;
import com.coding.temp.entity.Tables;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 表Mapper
 * @author Zhang Yongwei
 * @date 2019-03-20
 * @version 1.0
 */
@Repository
public interface TablesMapper  extends BaseDao<Tables> {

    /**
     * 根据对象检索
     * @param table
     * @return
     */
    Tables selectByPrimarySearch(Tables table);

}