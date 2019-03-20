package com.coding.temp.service;

import com.coding.temp.entity.User;
import com.coding.temp.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * 用户逻辑层
 * @author Zhang Yongwei
 * @date 2019-03-20
 * @version 1.0
 */
@Service
public interface UserService extends BaseService<User> {
    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    User selectByUserName(String userName);
}
