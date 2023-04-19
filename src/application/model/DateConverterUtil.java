package application.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverterUtil {
	
	public DateConverterUtil() {}
	
	public LocalDateTime stringToDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return dateTime;
	}
	
	public String localDateTimeToString(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String dateTimeStr = date.format(formatter);
		return dateTimeStr;
	}
}
