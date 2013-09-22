package com.kkazo.core.exception;

public class NotExistException extends ApplicationException {
	private static final long serialVersionUID = 1920814616395115613L;

	public NotExistException(Object source) {
		super(source);
	}
}
