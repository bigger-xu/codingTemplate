package com.coding.temp.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyongwei
 */
public interface BaseService<T> extends Serializable {
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 获取所有列表
     * @return
     */
    List<T> selectAllUserList();

    /**
     * 根据条件查询列表
     * @param map
     * @return
     */
    List<T> selectUserListByParams(Map<String, Object> map);

    /**
     * 插入
     * @param obj
     * @return
     */
    int insert(T obj);

    /**
     * 修改
     * @param obj
     * @return
     */
    int updateByPrimaryKeySelective(T obj);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 查询总条数
     * @return
     */
    int selectListCount();
}