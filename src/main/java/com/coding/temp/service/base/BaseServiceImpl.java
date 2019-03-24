package com.coding.temp.service.base;

import com.coding.temp.dao.base.BaseDao;
import com.coding.temp.utils.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author zhangyongwei
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    /**
     * 获取mapper
     * @return
     */
    public abstract BaseDao<T> getNameSpace();

    @Override
    public T selectByPrimaryKey(Long id) {
        return getNameSpace().selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAllList() {
        return getNameSpace().selectAllList();
    }

    @Override
    public List<T> selectListByParams(T obj) {
        return getNameSpace().selectListByParams(obj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(T obj) {
        return getNameSpace().insert(obj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(T obj) {
        return getNameSpace().updateByPrimaryKeySelective(obj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long id) {
        return getNameSpace().deleteByPrimaryKey(id);
    }

    @Override
    public int selectListCount() {
        return getNameSpace().selectListCount();
    }
}
