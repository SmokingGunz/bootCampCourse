package com.coderscampus.lesson9;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDatesApplication {

	public static void main(String[] args) {

//		lessong9();

//		lesson11();
		try {
			LocalDateTime jan1 = LocalDateTime.parse("2020/01/01 3:00 PM",
					DateTimeFormatter.ofPattern("yyyy/MM/dd h:mm a"));
			System.out.println(jan1);

			LocalDate endOfFeb = LocalDate.of(2020, 2, 05).with(TemporalAdjusters.lastDayOfMonth());
			System.out.println(endOfFeb);
			

		} catch (DateTimeException e) {
			System.out.println("Oops it doesn't look like your Date is formatted correctly");
		}

	}

	public static void lesson11() {
		LocalDateTime jan1 = LocalDateTime.of(2020, 1, 1, 0, 30, 0);
		System.out.println(jan1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a")));

		LocalDateTime jan2 = LocalDateTime.of(2020, 1, 2, 9, 0, 0);
		System.out.println("Is jan1 before jan2? " + jan1.isBefore(jan2));

		LocalDateTime jan3 = jan1.plusDays(1);

		System.out.println("Is jan2 after jan3? " + jan3.isAfter(jan2));

		jan3 = jan3.minus(1, ChronoUnit.DAYS);

		System.out.println(jan3);
	}

	public static void lessong9() {
		LocalDate date = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime datetime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.now();

		System.out.println(date);
		System.out.println(localTime);
		System.out.println(datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a z")));
	}

}
