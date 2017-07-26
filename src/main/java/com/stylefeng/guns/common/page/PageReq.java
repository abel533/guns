package com.stylefeng.guns.common.page;

import java.io.Serializable;

/**
 * @author liuzh
 * @since 2017/7/26.
 */
public class PageReq implements Serializable {
    private static final long serialVersionUID = -1524970970794892969L;

    private Integer limit;
    private Integer offset;
    private String  sort;
    private String  order;
    private boolean openSort;
    private boolean asc;

    public PageReq() {
    }

    public PageReq(Integer limit, Integer offset, String sort, String order) {
        this.limit = limit;
        this.offset = offset;
        this.sort = sort;
        this.order = order;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public boolean isOpenSort() {
        return openSort;
    }

    public void setOpenSort(boolean openSort) {
        this.openSort = openSort;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
