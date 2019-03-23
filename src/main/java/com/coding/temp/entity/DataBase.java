package com.coding.temp.entity;

import java.util.Date;
/**
 * 数据库
 * @author Zhang Yongwei
 * @date 2019-03-20
 * @version 1.0
 */
public class DataBase extends BaseEntity{
    private Long id;

    private String name;

    private String code;

    private String dbDesc;

    private String nameSpace;

    private Long connectId;

    private String dbPrefixSource;

    private Integer prefixFlag;

    private Long userId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDbDesc() {
        return dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc == null ? null : dbDesc.trim();
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace == null ? null : nameSpace.trim();
    }

    public Long getConnectId() {
        return connectId;
    }

    public void setConnectId(Long connectId) {
        this.connectId = connectId;
    }

    public String getDbPrefixSource() {
        return dbPrefixSource;
    }

    public void setDbPrefixSource(String dbPrefixSource) {
        this.dbPrefixSource = dbPrefixSource == null ? null : dbPrefixSource.trim();
    }

    public Integer getPrefixFlag() {
        return prefixFlag;
    }

    public void setPrefixFlag(Integer prefixFlag) {
        this.prefixFlag = prefixFlag;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}