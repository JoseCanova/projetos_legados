package br.com.valid.bio.agreement.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String MASK_INPUT_RFB= "yyyy-MM-dd";
	
	private static final String MASK_OUTPUT_RFB = "MM/dd/yyyy";
	
	public static boolean isDate(final String dateOfBirth) {
		return dateOfBirth.matches("^\\d{4}-\\d{2}-\\d{2}$");
	}
	
	public static String formatDateToRfbEndPoint(String dateStr) throws ParseException {
		Date dateFormat = new SimpleDateFormat(MASK_INPUT_RFB).parse(dateStr);
		return new SimpleDateFormat(MASK_OUTPUT_RFB).format(dateFormat);
	}
	
}
