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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件名${objectName}Controller.java
 *
 * @author ${author}
 * @date ${createTime}
 */
@Controller
@RequestMapping("${objectVariableName}")
public class ${objectName}Controller extends Base${objectName}Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectController.class);
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
     * @param model 模型
     * @return
     */
    @RequestMapping("page")
    public Object list(${objectName}Vo search, Model model) {
        try {
            //TODO 设置查询属性
            return ${objectVariableName}Service.selectPage(search);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e)
            return Result.error();
        }

    }

    /**
     * 创建或者更新${objectDes}
     *
     * @param model 模型
     * @param ${objectVariableName} ${objectDes}对象
     * @param result 绑定的结果集
     * @return
     */
    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    public Object saveOrUpdate(${objectName} ${objectVariableName}, HttpServletRequest request) {
        try {
            if (${objectVariableName}.getId() == null) {
                ${objectVariableName}.setCreateTime(new Date());
                ${objectVariableName}.setUserId(SessionUtil.getUserId(request));
                ${objectVariableName}Service.insert(${objectVariableName});
            } else {
                ${objectVariableName}.setUpdateTime(new Date());
                ${objectVariableName}Service.updateBySelective(${objectVariableName});
            }
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e)
            return Result.error();
        }
    }


    /**
     * 删除指定ID的${objectDes}信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public Object delete(@PathVariable("id") Long id, Model model) {
        try {
            ${objectVariableName}Service.deleteById(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求错误:{}",e)
            return Result.error();
        }
    }
}