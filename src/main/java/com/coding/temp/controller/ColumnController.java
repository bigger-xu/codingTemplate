package com.coding.temp.controller;

import com.coding.temp.entity.Column;
import com.coding.temp.service.ColumnService;
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

/**
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-23
 */
@Controller
@RequestMapping("column")
public class ColumnController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectController.class);
    @Autowired
    private ColumnService columnService;

    /**
     * 字段首页
     * @return
     */
    @RequestMapping
    public String index(Long tablesId, Model model){
        model.addAttribute("tablesId",tablesId);
        return "column/index";
    }

    /**
     * 列表数据
     * @return
     */
    @RequestMapping("page")
    @ResponseBody
    public Object list(Column connect, HttpServletRequest request){
        try {
            connect.setUserId(SessionUtil.getUserId(request));
            return columnService.selectPage(connect);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }
}
