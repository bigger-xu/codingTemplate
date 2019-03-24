<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${package}.dao.${objectName}Mapper" >
    <resultMap id="${objectName}ResultMap" type="${package}.entity.${objectName}" >
        <#list columnList as column>
        <result property="${column.attrVariableName}" column="${column.name}" />
        </#list>
    </resultMap>

    <sql id="${objectName}_Column_List" >
        <#list columnList as column>
        ${column.name}<#if column_has_next>,</#if>
        </#list>
    </sql>

    <insert id="insert" parameterType="${package}.entity.${objectName}">
        <selectKey resultType="java.lang.Long" order="AFTER" keyProperty="id">
            SELECT LAST_INSERT_ID()
        </selectKey>
        INSERT INTO ${tableName} (
        <include refid="${objectName}_Column_List" />
        ) VALUES (
        <#list columnList as column>
        ${r"#{"}${column.attrVariableName}${r"}"}<#if column_has_next>,</#if>
        </#list>
        )
    </insert>

    <update id="update" parameterType="${package}.entity.${objectName}">
        UPDATE ${tableName} SET
        <#list updateColumnList as column>
            <#if column.attrVariableName?exists>
        ${column.name} = ${r"#{"}${column.attrVariableName}${r"}"}<#if column_has_next>,</#if>
            </#if>
        </#list>
        WHERE
        id = ${r'#{id}'}
    </update>

    <update id="updateBySelective" parameterType="${package}.entity.${objectName}">
        UPDATE ${tableName}
        <set>
            <#list updateColumnList as column>
                <#if column.objectType?exists &&column.objectType=="String">
        ${r"<if test="}"${column.attrVariableName}!=null and ${column.attrVariableName}!=''"${r">"}
        ${column.name}=${r"#{"}${column.attrVariableName}${r"}"}<#if column_has_next>,</#if>
        ${r"</if>"}
                <#elseif column.attrVariableName?exists>
        ${r"<if test="}"${column.attrVariableName}!=null"${r">"}
        ${column.name}=${r"#{"}${column.attrVariableName}${r"}"}<#if column_has_next>,</#if>
        ${r"</if>"}
                </#if>
            </#list>
        </set>
        WHERE
        id = ${r"#{"}id${r"}"}
    </update>

    <select id="selectEntityById" parameterType="java.lang.Long" resultMap="${objectName}ResultMap">
        select <include refid="${objectName}_Column_List" /> from ${tableName} where id=${r"#{"}id${r"}"}
    </select>

    <select id="selectEntityBySearch" parameterType="${package}.entity.vo.${objectName}Vo" resultMap="${objectName}ResultMap">
        select <include refid="${objectName}_Column_List" /> from ${tableName} where 1=1
        <#list columnList as column>
            <#if column.objectType?exists  &&column.objectType=="String">
        ${r"<if test="}"${column.attrVariableName}!=null and ${column.attrVariableName}!=''"${r">"}
        and ${column.name} like CONCAT('%',${r"#{"}${column.attrVariableName}${r"}"},'%')
        ${r"</if>"}
            <#else>
        ${r"<if test="}"${column.attrVariableName}!=null"${r">"}
        and ${column.name}=${r"#{"}${column.attrVariableName}${r"}"}
        ${r"</if>"}
            </#if>
        </#list>
        <if test="sortStr != null and sortStr != ''">
            order by  ${r"${sortStr}"}
        </if>
    </select>

    <select id="selectPageList" parameterType="${package}.entity.vo.${objectName}Vo" resultMap="${objectName}ResultMap">
        <include refid="public_sql.page_begin" />
        select <include refid="${objectName}_Column_List" /> from ${tableName} where 1=1
        <#list columnList as column>
            <#if column.objectType?exists  &&column.objectType=="String">
        ${r"<if test="}"${column.attrVariableName}!=null and ${column.attrVariableName}!=''"${r">"}
        and ${column.name} like CONCAT('%',${r"#{"}${column.attrVariableName}${r"}"},'%')
        ${r"</if>"}
            <#else>
        ${r"<if test="}"${column.attrVariableName}!=null"${r">"}
        and ${column.name}=${r"#{"}${column.attrVariableName}${r"}"}
        ${r"</if>"}
            </#if>
        </#list>
        <if test="sortStr != null and sortStr != ''">
            order by ${r" ${sortStr}"}
        </if>
        limit ${r"#{startIndex}"},${r"#{pageSize}"}
    </select>

    <select id="selectListCount" parameterType="${package}.entity.vo.${objectName}Vo" resultType="java.lang.Integer">
        select count(1) from ${tableName} where 1=1
        <#list columnList as column>
            <#if column.objectType?exists  &&column.objectType=="String">
        ${r"<if test="}"${column.attrVariableName}!=null and ${column.attrVariableName}!=''"${r">"}
        and ${column.name} like CONCAT('%',${r"#{"}${column.attrVariableName}${r"}"},'%')
        ${r"</if>"}
            <#else>
        ${r"<if test="}"${column.attrVariableName}!=null"${r">"}
        and ${column.name}=${r"#{"}${column.attrVariableName}${r"}"}
        ${r"</if>"}
            </#if>
        </#list>
    </select>

    <delete id="deleteById" parameterType="java.lang.Long">
        DELETE FROM
        ${tableName}
        where id=${r"#{"}id${r"}"}
    </delete>
</mapper>