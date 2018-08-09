package com.mt.common;

/**
 * @author yongkang.zhang
 * created at 06/08/2018
 */
public class PageRequest {

    private int pageIndex = 1;
    private int pageSize = 10;

    public PageRequest() {
    }

    public PageRequest(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getOffset() {
        return (long) (pageIndex - 1) * pageSize;
    }

}
