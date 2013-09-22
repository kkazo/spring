package com.kkazo.core.exception;

public class NotFoundException extends ApplicationException {
	private static final long serialVersionUID = -6018272043303599259L;

	public NotFoundException(Object source) {
		super(source);
	}
}
