package com.coding.temp.entity;

import java.util.Date;
/**
 * 日志
 * @author Zhang Yongwei
 * @date 2019-03-20
 * @version 1.0
 */
public class CodeLog {
    private Long id;

    private Long userId;

    private String logLevelCode;

    private String logLevel;

    private Date createTime;

    private String logDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogLevelCode() {
        return logLevelCode;
    }

    public void setLogLevelCode(String logLevelCode) {
        this.logLevelCode = logLevelCode == null ? null : logLevelCode.trim();
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel == null ? null : logLevel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc == null ? null : logDesc.trim();
    }
}