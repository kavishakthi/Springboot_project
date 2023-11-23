package com.kavs.placement;

public class ApiResponse {

	private boolean success;
    private String message;
    private Placement data;
    
    public ApiResponse() {
		super();
	}
	public ApiResponse(boolean success, String message, Placement data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Placement getData() {
		return data;
	}
	public void setData(Placement data) {
		this.data = data;
	}
}
