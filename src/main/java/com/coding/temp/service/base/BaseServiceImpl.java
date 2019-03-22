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
    public T selectByPrimaryKey(Integer id) {
        return getNameSpace().selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAllList() {
        return getNameSpace().selectAllList();
    }

    @Override
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
    public int selectListCount() {
        return getNameSpace().selectListCount();
    }

    @Override
    public Page<T> selectPage(T obj){
        List<T> list = getNameSpace().selectPageList(obj);
        int count = getNameSpace().selectPageCount();
        Page<T> page = new Page<>(count);
        page.setItems(list);
        return page;
    }

}
