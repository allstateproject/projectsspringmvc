package com.allstate.training.ffd.exceptions;

public class BuisnessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public BuisnessException(String message) {
		super(message);
	}
	
	
}