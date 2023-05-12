package com.coderscampus.lesson6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatesApplication {

	public static void main(String[] args) {

//		lesson6();

//		lesson7();

//		lesson8();



	}

	public static void lesson8() {
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 0, 1);
		Date jan1 = cal.getTime();

// how to format date output

		System.out.println(jan1);
		DateFormat formatter = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss a z");
		String formattedDate = formatter.format(jan1);
		System.out.println(formattedDate);

		String dateValue1 = "2020-01-05 5:00 PM";
		String dateValue2 = "2019-01-01 10:00 PM";

// How to parse a date as a string using a formatter

		DateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd h:mm a"); // if you add a time zone here it break it
		Date date1;
		Date date2;
		try {
			date1 = formatter2.parse(dateValue1);
			date2 = formatter2.parse(dateValue2);
			if (date1.before(date2)) {
				System.out.println("date1 is before date2");
			}else {
				System.out.println("date1 is after date2");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void lesson7() {
		// This is depricated, don't use this approach, us Calendar instead

		Date jan012020 = new Date(120, 0, 1, 0, 0, 0);
		Calendar cal = Calendar.getInstance();
		System.out.println(jan012020);

		// Use this method!

		Date someOtherDate = cal.getTime();
		cal.set(2020, 0, 1, 15, 1, 5);
		someOtherDate = cal.getTime();
		System.out.println(someOtherDate);

		// how to add dates/times/etc

		cal.add(Calendar.HOUR, 2);
		System.out.println(cal.getTime());

		// How too remove dates/times/etc --- Use negetive numbers

		cal.add(Calendar.MINUTE, -1);
		System.out.println(cal.getTime());

		Date now = new Date();
		if (now.after(cal.getTime())) {
			System.out.println(now + " is after " + cal.getTime());
		}

		cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		System.out.println(cal.getTime());
	}

	public static void lesson6() {
		Date now = new Date();

		System.out.println(now);

		java.sql.Date jan011970 = new java.sql.Date(86400000); // time in milliseconds
		System.out.println(jan011970);
	}

}
