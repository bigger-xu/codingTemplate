/*
 * @(#)  ${objectName}Vo.java    ${createTime}
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package ${package}.service.impl;

import ${package}.entity.${objectName};
import ${package}.service.base.BaseService;
/**
 * 文件名 ${objectName}ServiceImpl.java 
 * 
 * @author ${author}
 * @date ${createTime}
 */
@Service
public class ${objectName}ServiceImpl extends BaseServiceImpl<${objectName}> implements ${objectName}Service {
    @Autowired
    private ${objectName}Mapper ${objectVariableName}Mapper;
    @Override
    public ${objectName}Mapper getNameSpace() {
        return ${objectVariableName}Mapper;
    }

    @Override
    public Page<${objectName}> selectPage(${objectName} connect) {
        Page<${objectName}> page = new Page<>(${objectVariableName}Mapper.selectPageCount(${objectVariableName}), connect.getPageSize(), connect.getPageNum());
        List<${objectName}> result = ${objectVariableName}Mapper.selectPageList(${objectVariableName});
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }
}