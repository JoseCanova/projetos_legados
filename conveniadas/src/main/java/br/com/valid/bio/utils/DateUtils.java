package br.com.valid.bio.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	
	private static DateTimeFormatter dateTimeFormatterRequest = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
	
	public static boolean isDate(final String dateOfBirth) {
		return dateOfBirth.matches("^\\d{2}/\\d{2}/\\d{4}$");
	}
	
	//TODO: efetuar testes e corrigir se nescessário este método. 
	//Proposito do metodo formatar data de saida para chamadas ABIS.
	public static LocalDate formatDate(LocalDate localDate) { 
		  String text = localDate.format(dateTimeFormatterRequest);
		  return LocalDate.parse(text, dateTimeFormatterRequest);
	}
	
}
