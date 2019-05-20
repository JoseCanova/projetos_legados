package org.nanotek.mail;

public class EndPointException extends Exception {

	public EndPointException() {
	}

	public EndPointException(String message) {
		super(message);
	}

	public EndPointException(Throwable cause) {
		super(cause);
	}

	public EndPointException(String message, Throwable cause) {
		super(message, cause);
	}

	public EndPointException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
