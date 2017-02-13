package com.Accer.GetDateTime.GetCurrentDateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class GetCurrentDateTime {

	public String getCurrentDate() {
		String dateformat = "MM/dd/yyyy";
		return getTodayDate(dateformat);
	}

	public String getCurrentTime() {
		TimeZone timeZone = TimeZone.getTimeZone("IST");
		String timeFormat = "hh:mm:ss";
		return getCurrentTime(timeFormat, timeZone);
	}

	private String getCurrentTime(String timeFormat, TimeZone timeZone) {
		DateFormat dateFormat = new SimpleDateFormat(timeFormat);
		Calendar cal = Calendar.getInstance(timeZone);
		dateFormat.setTimeZone(cal.getTimeZone());
		String currentTime = dateFormat.format(cal.getTime());
		return currentTime;
	}

	private String getTodayDate(String dateFormat) {
		TimeZone timeZone = TimeZone.getTimeZone("IST");
		Date todayDate = new Date();
		DateFormat todayDateFormat = new SimpleDateFormat(dateFormat);
		todayDateFormat.setTimeZone(timeZone);
		String strTodayDate = todayDateFormat.format(todayDate);
		return strTodayDate;
	}
	
	
}
