package org.hubotek;

@SuppressWarnings("serial")
public class TransformationException extends RuntimeException {

	public TransformationException() {
		super();
	}

	public TransformationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TransformationException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransformationException(String message) {
		super(message);
	}

	public TransformationException(Throwable cause) {
		super(cause);
	}
	
}
