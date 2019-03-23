package com.coding.temp.entity;

import java.util.Date;

public class Column extends BaseEntity{
    private Long id;

    private String attrName;

    private String attrVariableName;

    private String name;

    private String columnsDesc;

    private String columnsType;

    private String objectType;

    private String packageName;

    private String displayTypeCode;

    private String displayType;

    private String validateTypeCode;

    private String validateType;

    private String displayPositionCode;

    private String displayPosition;

    private String searchFlag;

    private Long tableId;

    private Long userId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public String getAttrVariableName() {
        return attrVariableName;
    }

    public void setAttrVariableName(String attrVariableName) {
        this.attrVariableName = attrVariableName == null ? null : attrVariableName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getColumnsDesc() {
        return columnsDesc;
    }

    public void setColumnsDesc(String columnsDesc) {
        this.columnsDesc = columnsDesc == null ? null : columnsDesc.trim();
    }

    public String getColumnsType() {
        return columnsType;
    }

    public void setColumnsType(String columnsType) {
        this.columnsType = columnsType == null ? null : columnsType.trim();
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public String getDisplayTypeCode() {
        return displayTypeCode;
    }

    public void setDisplayTypeCode(String displayTypeCode) {
        this.displayTypeCode = displayTypeCode == null ? null : displayTypeCode.trim();
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType == null ? null : displayType.trim();
    }

    public String getValidateTypeCode() {
        return validateTypeCode;
    }

    public void setValidateTypeCode(String validateTypeCode) {
        this.validateTypeCode = validateTypeCode == null ? null : validateTypeCode.trim();
    }

    public String getValidateType() {
        return validateType;
    }

    public void setValidateType(String validateType) {
        this.validateType = validateType == null ? null : validateType.trim();
    }

    public String getDisplayPositionCode() {
        return displayPositionCode;
    }

    public void setDisplayPositionCode(String displayPositionCode) {
        this.displayPositionCode = displayPositionCode == null ? null : displayPositionCode.trim();
    }

    public String getDisplayPosition() {
        return displayPosition;
    }

    public void setDisplayPosition(String displayPosition) {
        this.displayPosition = displayPosition == null ? null : displayPosition.trim();
    }

    public String getSearchFlag() {
        return searchFlag;
    }

    public void setSearchFlag(String searchFlag) {
        this.searchFlag = searchFlag == null ? null : searchFlag.trim();
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
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