/*
 * @(#)  ${objectName}Controller.java    ${createTime}
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package ${package}.controller;

import ${package}.entity.${objectName};
import ${package}.entity.vo.${objectName}Vo;
import ${package}.service.${objectName}Service;
import ${package}.utils.Result;
import ${package}.utils.SessionUtil;
import ${package}.controller.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 文件名${objectName}Controller.java
 *
 * @author ${author}
 * @date ${createTime}
 */
@Controller
@RequestMapping("${objectVariableName}")
public class ${objectName}Controller extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(${objectName}Controller.class);
    @Autowired
    private ${objectName}Service ${objectVariableName}Service;

    /**
     * 获取${objectDes}列表页
     * @return
     */
    @RequestMapping
    public String index(Model model) {
        return "${objectVariableName}/index";
    }

    /**
     * 获取${objectDes}分页数据
     *
     * @param search 查询条件
     * @return
     */
    @RequestMapping("page")
    @ResponseBody
    public Object list(${objectName}Vo search) {
        try {
            //TODO 设置查询属性
            return ${objectVariableName}Service.selectPage(search);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }

    }


    /**
     * 获取${objectDes}添加页
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(Model model) {
        return "${objectVariableName}/add";
    }

    /**
     * 获取${objectDes}编辑页
     * @return
     */
    @RequestMapping(value = "/edit")
    public String edit(Long id,Model model) {
        if(id != null){
            ${objectName} ${objectVariableName} = ${objectVariableName}Service.selectEntityById(id);
            model.addAttribute("${objectVariableName}", ${objectVariableName});
        }
        return "${objectVariableName}/edit";
    }

    /**
     * 创建或者更新${objectDes}
     * @param ${objectVariableName} ${objectDes}对象
     * @return
     */
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdate(${objectName} ${objectVariableName}) {
        try {
            if (${objectVariableName}.getId() == null) {
                ${objectVariableName}.setAddTime(new Date());
                ${objectVariableName}Service.insert(${objectVariableName});
            } else {
                ${objectVariableName}.setUpdateTime(new Date());
                ${objectVariableName}Service.updateBySelective(${objectVariableName});
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }

    /**
     * 删除指定ID的${objectDes}信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Long id, Model model) {
        try {
            ${objectVariableName}Service.deleteById(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e);
            return Result.error();
        }
    }
}
