package com.epam.osmachko.exception;

import java.sql.SQLException;

public class DataBaseException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 916352574340528425L;

	
	
	public DataBaseException(String message, SQLException ex) {
		super(message,ex);
	}
}
