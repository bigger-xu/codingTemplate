/*
 * @(#)  ${objectName}Vo.java    ${createTime}
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package ${package}.service;

import ${package}.entity.${objectName};
import ${package}.service.base.BaseService;
/**
 * 文件名 ${objectName}Service.java
 * 
 * @author ${author}
 * @date ${createTime}
 */
public interface ${objectName}Service extends BaseService<${objectName}> {
    /**
     * 查询分页
     * @param connect
     * @return
     */
    Page<${objectName}> selectPage(${objectName} ${objectVariableName});
}
