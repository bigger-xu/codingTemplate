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
	<#if column.attrVariableName?exists &&column.attrVariableName!="id">
	/**
	 * 属性${column.attrName}(${column.columnsDesc})
	 */
	private ${column.objectType} ${column.attrVariableName};
	</#if>
 </#list>

<#list columnList as column>
  <#if column.attrVariableName?exists &&column.attrVariableName!="id">
	/**
	 *  获取属性${column.attrName}(${column.columnsDesc})
	 * @return ${column.objectType}
	 * @author ${author}
	 * @date ${createTime}
	*/
	public ${column.objectType} get${column.attrName}(){
		return ${column.attrVariableName};
	}
	/**
	* 设置属性${column.attrName}(${column.columnsDesc})
	* @param ${column.attrVariableName}
	* @return void
	* @author ${author}
	* @date  ${createTime}
	*/
	public void set${column.attrName}(${column.objectType} ${column.attrVariableName} ){
		this.${column.attrVariableName} = ${column.attrVariableName} ;
	}
 </#if>
</#list>
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		<#list columnList as column>
		sb.append("${column.attrName}(${column.columnsDesc}):").append(${column.attrVariableName}).append(" ");
		</#list>
		return sb.toString();
	}
}
