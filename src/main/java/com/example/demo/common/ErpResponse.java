package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErpResponse {
	private Long statusCode;
	private String message;
	@JsonInclude(Include.NON_NULL)
	private Pagination pagination;
	private Object object;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Long statusCode) {
		this.statusCode = statusCode;
	}
}
