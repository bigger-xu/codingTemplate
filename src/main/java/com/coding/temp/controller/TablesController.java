package com.coding.temp.controller;

import com.coding.temp.entity.Tables;
import com.coding.temp.service.TablesService;
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
 * @date 2019-03-22
 */
@Controller
@RequestMapping("tables")
public class TablesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectController.class);
    @Autowired
    private TablesService tablesService;

    /**
     * 数据库首页
     * @return
     */
    @RequestMapping
    public String index(){
        return "tables/index";
    }

    /**
     * 列表数据
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Object list(Tables tables){
        try {
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    /**
     * 添加或者修改
     * @param tables
     * @return
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Tables tables){
        try{
            Date date  = new Date();
            if(tables.getId() != null){
                tables.setCreateTime(date);
                tablesService.insert(tables);
            }else{
                tablesService.updateByPrimaryKeySelective(tables);
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
            tablesService.deleteByPrimaryKey(id);
            return Result.ok();
        }catch (Exception e){
            return Result.error();
        }
    }
}
