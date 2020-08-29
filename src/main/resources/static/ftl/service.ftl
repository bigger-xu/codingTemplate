/*
 * @(#)  ${objectName}Vo.java    ${createTime}
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package ${package}.service;

import ${package}.entity.${objectName};
import ${package}.service.base.BaseService;
import ${package}.utils.Page;
/**
 * 文件名 ${objectName}Service.java
 * 
 * @author ${author}
 * @date ${createTime}
 */
public interface ${objectName}Service extends BaseService<${objectName}> {
    /**
     * 查询分页
     * @param ${objectVariableName}
     * @return Page<${objectName}>
     */
    Page<${objectName}> selectPage(${objectName} ${objectVariableName});

    /**
     * 添加或者修改
     * @param ${objectVariableName}
     * @return null
     */
    void saveOrUpdate(${objectName} ${objectVariableName});
}
