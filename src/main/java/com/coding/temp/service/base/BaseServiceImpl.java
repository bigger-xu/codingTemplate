package com.coding.temp.service.base;

import com.coding.temp.dao.base.BaseDao;
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
    @Transactional(rollbackFor = Exception.class)
    public T selectByPrimaryKey(Integer id) {
        return getNameSpace().selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<T> selectAllUserList() {
        return getNameSpace().selectAllUserList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<T> selectUserListByParams(Map<String, Object> map) {
        return getNameSpace().selectUserListByParams(map);
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
    public int deleteByPrimaryKey(Integer id) {
        return getNameSpace().deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int selectListCount() {
        return getNameSpace().selectListCount();
    }
}
