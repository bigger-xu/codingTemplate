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

import java.util.Date;

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

    /**
     * 数据库连接首页
     * @return
     */
    @RequestMapping
    public String index(){
        return "connect/index";
    }

    /**
     * 列表数据
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Result list(){
        
        return null;
    }

    /**
     * 添加或者修改
     * @param connect
     * @return
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Result saveOrUpdate(Connect connect){
        try{
            Date date  = new Date();
            if(connect.getId() != null){
                connect.setCreateTime(date);
                connectService.insert(connect);
            }else{
                connectService.updateByPrimaryKeySelective(connect);
            }
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public Result delete(Integer id){
        try{
            connectService.deleteByPrimaryKey(id);
            return Result.ok();
        }catch (Exception e){
            return Result.error();
        }
    }
}
