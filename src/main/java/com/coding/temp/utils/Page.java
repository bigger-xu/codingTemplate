package com.coding.temp.utils;

import java.util.List;

/**
 * @author Zhang Yongei
 * @version 1.0
 * @date 2019-03-22
 */
public class Page<T> {
    /**
     * 起始页
     */
    private Integer startPage = 1;
    /**
     * 每页总条数
     */
    private Integer pageSize = 10;
    /**
     * 总条数
     */
    private Integer totalNum;
    /**
     * 是否有下一页
     */
    private Integer isMore;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 开始索引
     */
    private Integer startIndex;
    /**
     * 分页结果
     */
    private List<T> items;

    public Page() {
        super();
    }

    public Page(Integer totalNum) {
        super();
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.startPage-1)*this.pageSize;
        this.isMore = this.startPage >= this.totalPage?0:1;
    }

    public Page(Integer startPage, Integer pageSize, Integer totalNum) {
        super();
        this.startPage = startPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.startPage-1)*this.pageSize;
        this.isMore = this.startPage >= this.totalPage?0:1;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
