package br.com.valid.bio.conveniadas.abis.service.key;

@SuppressWarnings("serial")
public class KeyServiceFactoryException extends RuntimeException {

	public KeyServiceFactoryException() {
	}

	public KeyServiceFactoryException(String message) {
		super(message);
	}

	public KeyServiceFactoryException(Throwable cause) {
		super(cause);
	}

	public KeyServiceFactoryException(String message, Throwable cause) {
		super(message, cause);
	}

}