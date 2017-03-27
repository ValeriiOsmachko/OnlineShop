package com.epam.osmachko.exception;


public class BusinessLogicException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8757697424396948856L;

	
	public BusinessLogicException(String message, Throwable ex) {
		super(message,ex);
	}
	
}
