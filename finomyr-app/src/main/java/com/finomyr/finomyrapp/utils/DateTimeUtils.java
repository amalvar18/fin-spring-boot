package com.finomyr.finomyrapp.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for date and time operations
 * @author amalvar
 * @since 0.0.2
 * @version 0.2
 */
public class DateTimeUtils {
	
	/**
	 * Gets the current datetime as a formatted string
	 * @param dateStyle the style to format the date with
	 * @return The date as a string dateStyle format
	 * @since 0.1
	 */
	public static String currentDateTime(String dateStyle) {
		/*StringBuilder formattedDate = new StringBuilder();*/
		LocalDateTime dateTime = LocalDateTime.now();
		/*String dateStyle = "dd MMM YYYY HH:mm:ss";*/
		String formattedDate = dateTime.format(DateTimeFormatter.ofPattern(dateStyle));		
		return formattedDate;
		/*return formattedDate.toString();*/
	}

}
