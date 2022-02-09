package com.example.demo.dto;

public class Response {

	private String statusMessage;
	private Long statusCode;
	private Object Token;
	
	public Response(String statusMessage, Long statusCode, Object token) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		Token = token;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Long statusCode) {
		this.statusCode = statusCode;
	}

	public Object getToken() {
		return Token;
	}

	public void setToken(Object token) {
		Token = token;
	}
	
	
	
	
}
