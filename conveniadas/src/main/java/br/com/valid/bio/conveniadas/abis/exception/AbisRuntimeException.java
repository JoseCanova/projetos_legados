package br.com.valid.bio.conveniadas.abis.exception;

public class AbisRuntimeException extends RuntimeException{

	private static final long serialVersionUID = -3128634409893711475L;

	public AbisRuntimeException() {
		super();
	}

	public AbisRuntimeException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AbisRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AbisRuntimeException(String arg0) {
		super(arg0);
	}

	public AbisRuntimeException(Throwable arg0) {
		super(arg0);
	}

	
	
}
