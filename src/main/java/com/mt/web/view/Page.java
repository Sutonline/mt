package com.mt.web.view;

import com.mt.common.PageRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongkang.zhang
 * created at 06/08/2018
 */
public class Page<T> {

    private long pageIndex;
    private long pageSize;
    private long totalItems;
    private long totalPages;
    private List<T> result;
    private String errorCode;
    private String errorMsg;

    public Page() {
        this.pageIndex = 1;
        this.pageSize = 10;
        this.totalPages = (long) 0;
        this.result = new ArrayList<>();
    }

    public Page(PageRequest pageRequest, long totalItems, List<T> list) {
        this.setPageIndex(pageRequest.getPageIndex());
        this.setPageSize(pageRequest.getPageSize());
        this.setTotalItems(totalItems);
        this.setResult(list);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
        if(this.pageSize > 0){
            this.totalPages = (this.totalItems / this.pageSize) + ((this.totalItems % this.pageSize) == 0 ? 0 : 1);
        }
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public static <T> Page<T> emptyPage() {
        return new Page<>();
    }
}
