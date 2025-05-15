package com.midominio.accounts.model;

public class ErrorResponse {
	
	private int code;
	private String message;
	private ErrorType type;
	private String details;
	private String location;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorType getType() {
		return type;
	}
	public void setType(ErrorType type) {
		this.type = type;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
