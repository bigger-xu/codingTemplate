/*
 * @(#)  ${objectName}Vo.java    ${createTime}
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package ${package}.entity;

import ${package}.entity.base.BaseEntity;
import java.util.Date;

/**
 * 文件名${objectName}.java
 * @author ${author}
 * @date ${createTime}
 *  
 */
public class ${objectName} extends BaseEntity{
    
	/**
	 * 默认构造函数
	 * @author ${author}
	 * @date ${createTime}
	 */
	public ${objectName}() {

	}
<#list columnList as column>
	<#if column.attrVariableName?exists>
	/**
	 * ${column.attrName}【${column.columnsDesc}】
	 */
	private ${column.objectType} ${column.attrVariableName};
	</#if>
 </#list>

 	/**
	 * Get/Set方法
	 * @author ${author}
	 * @date ${createTime}
	 */
<#list columnList as column>
  <#if column.attrVariableName?exists>
	public ${column.objectType} get${column.attrName}(){
		return ${column.attrVariableName};
	}
	
	public void set${column.attrName}(${column.objectType} ${column.attrVariableName} ){
		this.${column.attrVariableName} = ${column.attrVariableName} ;
	}
 </#if>
</#list>
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		<#list columnList as column>
		sb.append("${column.attrName}:").append(${column.attrVariableName}).append(" ");
		</#list>
		return sb.toString();
	}
}
