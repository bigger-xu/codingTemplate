package com.coding.temp.controller;

import com.coding.temp.entity.Connect;
import com.coding.temp.service.ConnectService;
import com.coding.temp.utils.Result;
import com.coding.temp.utils.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("page")
    @ResponseBody
    public Object list(Connect connect,HttpServletRequest request){
        try {
            connect.setUserId(SessionUtil.getUserId(request));
            return connectService.selectPage(connect);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping("add")
    public String add(){
        return "connect/add";
    }

    /**
     * 修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("edit")
    public String edit(Long id, Model model){
        Connect connect = connectService.selectByPrimaryKey(id);
        model.addAttribute("connect",connect);
        return "connect/edit";
    }

    /**
     * 添加或者修改
     * @param connect
     * @return
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Connect connect, HttpServletRequest request){
        try{
            Date date  = new Date();
            if(connect.getId() == null){
                connect.setUserId(SessionUtil.getUserId(request));
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
    public Object delete(Long id){
        try{
            connectService.deleteByPrimaryKey(id);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    /**
     * 生成数据库
     * @param id
     * @return
     */
    @RequestMapping("createDateBase")
    @ResponseBody
    public Object createDateBase(Long id,HttpServletRequest request){
        try{
            Boolean flag = connectService.createDateBase(id,SessionUtil.getUserId(request));
            if(flag){
                return Result.ok();
            }else{
                return Result.error();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }
}
