package com.wipro.capstoneproject.exception;

public class PasswordDoesNotMatchException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3495353509432864861L;

	public PasswordDoesNotMatchException() {
		super();
	}

	public PasswordDoesNotMatchException(String message) {
		super("message");
	}
}
