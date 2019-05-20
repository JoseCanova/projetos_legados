package br.com.valid.bio.agreement.exception;

public class ErrorMessage {

	private static final String errorMessage = "OCORREU UM ERRO";
	
	public String handleException(Exception ex) { 
		return errorMessage;
	}
	
}
