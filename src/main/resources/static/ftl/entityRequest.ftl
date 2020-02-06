/*
 * @(#)  ${objectName}Request.java    ${createTime}
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package ${package}.entity.vo.request;

import ${package}.entity.${objectName};
import ${package}.entity.CustomConstants;

/**
 * 文件名 ${objectName}Request.java
 * 
 * @author ${author}
 * @date ${createTime}
 */
public class ${objectName}Request extends ${objectName} {
    private Integer pageNum = CustomConstants.PageQuery.DEFAULT_PAGE_NUMBER;
    private Integer pageSize = CustomConstants.PageQuery.DEFAULT_PAGE_SIZE;
    private String sortStr = CustomConstants.PageQuery.DEFAULT_SORT;
    private Integer startIndex;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortStr() {
        return sortStr;
    }

    public void setSortStr(String sortStr) {
        this.sortStr = sortStr;
    }

    public Integer getStartIndex() {
        return (pageNum - 1) * pageSize < 0 ? 0 : (pageNum - 1) * pageSize;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }
}
