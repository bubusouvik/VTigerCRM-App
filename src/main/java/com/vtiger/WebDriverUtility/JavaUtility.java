package com.vtiger.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	// Random number generate

	public int randomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(7000);
		return randomNumber;
	}

	// System date generate
	public String getTodayDateWithFormatyyyyMMdd() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(d);
		return date;
	}

	// expected date from today
	public String expectedDateWithFormatyyyyMMdd(int days) {

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todayDate = sdf.format(d);
		Calendar cal = sdf.getCalendar();
		cal.add(cal.DAY_OF_MONTH, days);
		String expectedTime = sdf.format(cal.getTime());
		return expectedTime;
	}

}
