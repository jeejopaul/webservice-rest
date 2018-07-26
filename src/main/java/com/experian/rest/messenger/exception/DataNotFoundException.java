package com.experian.rest.messenger.exception;

public class DataNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 20180725L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
