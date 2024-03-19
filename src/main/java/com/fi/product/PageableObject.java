package com.fi.product;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageableObject<T> {

    private List<T> data;
    private long totalPages;
    private long totalElements;
    private int currentPage;
    public PageableObject(Page<T> page) {
        this.data = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber();
    }
	public List<T> getData() {
		return data;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public int getCurrentPage() {
		return currentPage;
	}
    
    
}
