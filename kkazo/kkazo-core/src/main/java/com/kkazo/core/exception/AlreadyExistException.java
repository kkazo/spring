package com.kkazo.core.exception;

public class AlreadyExistException extends ApplicationException {
	private static final long serialVersionUID = 4220724925805626069L;

	public AlreadyExistException(Object source) {
		super(source);
	}
}
