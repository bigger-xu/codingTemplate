package com.coding.temp.controller;

import com.coding.temp.entity.User;
import com.coding.temp.service.UserService;
import com.coding.temp.utils.Md5Util;
import com.coding.temp.utils.Result;
import com.coding.temp.utils.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-21
 */
@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public Result login(String userName, String password, HttpServletRequest request){
        User user = userService.selectByUserName(userName);
        if(user != null){
            if(user.getPassword().equals(Md5Util.compute(password))){
                SessionUtil.setUser(request, user);
                LOGGER.info("用户登录成功,用户名:{}",user.getUserName());
                return Result.ok();
            }else{
                return Result.error();
            }
        }else{
            return Result.error();
        }
    }
}
