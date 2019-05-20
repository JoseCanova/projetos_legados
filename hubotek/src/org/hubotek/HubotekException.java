package org.hubotek;

@SuppressWarnings("serial")
public class HubotekException extends RuntimeException{

	public HubotekException() {
		super();
	}

	public HubotekException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HubotekException(String message, Throwable cause) {
		super(message, cause);
	}

	public HubotekException(String message) {
		super(message);
	}

	public HubotekException(Throwable cause) {
		super(cause);
	}

}
