package com.christuniversity.careercounsellingbackend.model;


public class Error  extends  RuntimeException  {
	
	private static final long serialVersionUID = 1L;
	
	
	private String message;
	
	
	public Error(String message) {

		this.message = message;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
