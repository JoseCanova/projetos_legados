package br.com.valid.bio.utils;

public class DateUtils {

	public static boolean isDate(final String dateOfBirth) {
		return dateOfBirth.matches("^\\d{2}/\\d{2}/\\d{4}$");
	}
	
}
