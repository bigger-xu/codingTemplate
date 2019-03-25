package com.coding.temp.controller;

import com.coding.temp.entity.DataBase;
import com.coding.temp.service.DataBaseService;
import com.coding.temp.utils.Result;
import com.coding.temp.utils.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Zhang Yongei
 * @version 1.0
 * @date 2019-03-22
 */
@Controller
@RequestMapping("dataBase")
public class DataBaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectController.class);
    @Autowired
    private DataBaseService dataBaseService;

    /**
     * 数据库首页
     * @return
     */
    @RequestMapping
    public String index(Long connectId, Model model){
        model.addAttribute("connectId",connectId);
        return "dataBase/index";
    }

    /**
     * 列表数据
     * @return
     */
    @RequestMapping("page")
    @ResponseBody
    public Object list(DataBase dataBase, HttpServletRequest request){
        try {
            dataBase.setUserId(SessionUtil.getUserId(request));
            return dataBaseService.selectPage(dataBase);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    /**
     * 添加或者修改
     * @param dataBase
     * @return
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(DataBase dataBase){
        Date date  = new Date();
        try{
            if(dataBase.getId() != null){
                dataBase.setCreateTime(date);
                dataBaseService.insert(dataBase);
            }else{
                dataBaseService.updateByPrimaryKeySelective(dataBase);
            }
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    /**
     * 修改命名空间
     * @param dataBase
     * @return
     */
    @RequestMapping("updateNameSpace")
    @ResponseBody
    public Object updateNameSpace(DataBase dataBase){
        try{
            dataBaseService.updateByPrimaryKeySelective(dataBase);
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
            dataBaseService.deleteByPrimaryKey(id);
            return Result.ok();
        }catch (Exception e){
            return Result.error();
        }
    }

    /**
     * 生成表
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("createTables")
    @ResponseBody
    public Object createTables(Long id,HttpServletRequest request){
        try{
            Boolean flag = dataBaseService.createTables(id,SessionUtil.getUserId(request));
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
