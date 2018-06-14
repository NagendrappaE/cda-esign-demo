package com.evolvus.bean;

import org.springframework.http.HttpStatus;

public class ResponseJson {

	private HttpStatus status;
	private String data;
	private String description;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
