package org.nanotek;

public class BaseInstantiationException extends Exception {

	public BaseInstantiationException() {
	}

	public BaseInstantiationException(String message) {
		super(message);
	}

	public BaseInstantiationException(Throwable cause) {
		super(cause);
	}

	public BaseInstantiationException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseInstantiationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
