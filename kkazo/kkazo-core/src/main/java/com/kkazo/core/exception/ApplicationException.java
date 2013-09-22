package com.kkazo.core.exception;

public class ApplicationException extends Exception {
	private static final long serialVersionUID = 5966437830705860754L;
	protected Object source;

	public ApplicationException(Object source) {
		this.source = source;
	}

	public Object getSource() {
		return source;
	}
}
