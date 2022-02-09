package com.example.demo.exception;

import java.util.Locale;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.Response;

public class UserException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private Long StatusCode;
	private String Statusmessage;
	
	
	
	public Long getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(Long statusCode) {
		StatusCode = statusCode;
	}

	public String getStatusmessage() {
		return Statusmessage;
	}

	public void setStatusmessage(String statusmessage) {
		Statusmessage = statusmessage;
	}

	public UserException(Long statusCode, String statusmessage) {
		super();
		StatusCode = statusCode;
		Statusmessage = statusmessage;
	}
	
	public Response getErrorResponse() {
		return getErrorResponse(Locale.getDefault());
	}
	public Response getErrorResponse(Locale locale) {
		ErrorResponse err = new ErrorResponse(Statusmessage,StatusCode, getStackTrace());
		err.setStatusCode(getStatusCode());
		err.setStatusMessage(getStatusmessage());
		return err;
	

}
}
