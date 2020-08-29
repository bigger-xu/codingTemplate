/*
 * @(#)  ${objectName}Vo.java    ${createTime}
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package ${package}.service.impl;

import ${package}.entity.${objectName};
import ${package}.dao.${objectName}Mapper;
import ${package}.service.${objectName}Service;
import ${package}.service.base.BaseServiceImpl;
import ${package}.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
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
    public Page<${objectName}> selectPage(${objectName} ${objectVariableName}) {
        Page<${objectName}> page = new Page<>(${objectVariableName}Mapper.selectPageCount(${objectVariableName}), ${objectVariableName}.getPageSize(), ${objectVariableName}.getPageNum());
        List<${objectName}> result = ${objectVariableName}Mapper.selectPageList(${objectVariableName});
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public void saveOrUpdate(${objectName} ${objectVariableName}){
        Date date = new Date();
        if (${objectVariableName}.getId() == null) {
            ${objectVariableName}.setAddTime(date);
            this.insert(${objectVariableName});
        } else {
            ${objectVariableName}.setUpdateTime(date);
            this.updateBySelective(${objectVariableName});
        }
    }
}