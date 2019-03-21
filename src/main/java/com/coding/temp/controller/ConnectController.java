package com.coding.temp.controller;

import com.coding.temp.entity.Connect;
import com.coding.temp.service.ConnectService;
import com.coding.temp.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhang Yongei
 * @version 1.0
 * @description
 * @date 2019-03-21
 */
@Controller
@RequestMapping("connect")
public class ConnectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectController.class);
    @Autowired
    private ConnectService connectService;

    @RequestMapping
    public String index(){
        return "connect/index";
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Result saveOrUpdate(Connect connect){

        return null;
    }
}
