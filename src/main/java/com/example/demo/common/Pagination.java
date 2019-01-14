package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Pagination {
	private int totalItem; // count all item
	private int limitItem; // item per page
	@JsonInclude(Include.NON_NULL)
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public int getLimitItem() {
		return limitItem;
	}

	public void setLimitItem(int limitItem) {
		this.limitItem = limitItem;
	}
}