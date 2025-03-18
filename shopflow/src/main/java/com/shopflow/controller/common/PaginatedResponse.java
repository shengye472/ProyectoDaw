package com.shopflow.controller.common;

import java.util.List;

public class PaginatedResponse<T>{
    private List<T> data;
    private int total;
    private int currentPage;
    private int pageSize;
    private String next;
    private String previous;


    public PaginatedResponse(List<T> data, int total, int currentPage, int pageSize, String baseURL){
        this.data = data;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.next = createNextLink(baseURL);
        this.previous = createPreviousLink(baseURL);
    }

    private String createNextLink(String baseURL) {
        if (currentPage * pageSize < total) {
            return baseURL + "?page=" + (currentPage+1) + "&size=" + pageSize;
        }
        return null;
    }

    private String createPreviousLink(String baseURL) {
        if (currentPage > 1){
            return baseURL + "?page=" + (currentPage - 1) + "&size=" + pageSize;
        }
        return null;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
