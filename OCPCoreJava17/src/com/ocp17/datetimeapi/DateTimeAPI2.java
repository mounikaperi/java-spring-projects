package com.ocp17.datetimeapi;

import java.time.*;
import java.time.temporal.ChronoUnit;


public class DateTimeAPI2 {

	public static void main(String[] args) {
		
		System.out.println("LocalDate: " + LocalDate.now());
		System.out.println("LocalTime: " + LocalTime.now());
		System.out.println("LocalDateTime: " + LocalDateTime.now());
		System.out.println("ZonedDateTime: " + ZonedDateTime.now());
		
		/*  LocalDate: 2024-05-07
			LocalTime: 17:46:58.549527600
			LocalDateTime: 2024-05-07T17:46:58.549527600
			ZonedDateTime: 2024-05-07T17:46:58.550522500+05:30[Asia/Calcutta]
		*/
		System.out.println("-------------------------------------------");
		var date1 = LocalDate.of(2022, Month.JANUARY, 20);
		var date2 = LocalDate.of(2022, 1, 20);
		
		System.out.println("LocalDate (int year, int month, int dayOfMonth: " + date1);
		System.out.println("LocalDate (int year, Month month, int dayOfMonth: " + date2);
		
		 
		/*
		 * 2022-01-20
		   2022-01-20
		 */
		
		System.out.println("-------------------------------------------");
		var time1 = LocalTime.of(6, 15);
		var time2 = LocalTime.of(6, 15, 30);
		var time3 = LocalTime.of(6,  15, 30, 200);
		
		System.out.println("LocalTime (int hour, int minute): " + time1);
		System.out.println("LocalTime (int hour, int minute, int second): " + time2);
		System.out.println("LocalTime (int hour, int minute, int second, int nanos): " + time3);
		
		/*
		 *  06:15
			06:15:30
			06:15:30.000000200
		 */
		System.out.println("-------------------------------------------");
		var dateTime1 = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15);
		var dateTime2 = LocalDateTime.of(date1, time2);
		var dateTime3 = LocalDateTime.of(date1, time3);
		
		System.out.println("LocalDateTime (int year, Month month, int dayOfMonth, int hour, int minute): " + dateTime1);
		System.out.println("LocalDateTime (int year, Month month, int dayOfMonth, int hour, int minute, int second): " + dateTime2);
		System.out.println("LocalDateTime (int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanos): " + dateTime3);;
	
		
		System.out.println("-------------------------------------------");
		var dateTime4 = LocalDateTime.of(2022, 5, 20, 6, 15);
		var dateTime5 = LocalDateTime.of(date1, time2);
		var dateTime6 = LocalDateTime.of(date1, time3);
		
		System.out.println("LocalDateTime (int year, int month, int dayOfMonth, int hour, int minute): " + dateTime4);
		System.out.println("LocalDateTime (int year, int month, int dayOfMonth, int hour, int minute, int second): " + dateTime5);
		System.out.println("LocalDateTime (int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos): " + dateTime6);;
		
		System.out.println("-------------------------------------------");
		var zone = ZoneId.of("US/Eastern");
		var zone1 = ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone);
		var zone2 = ZonedDateTime.of(date1, time1, zone);
		var zone3 = ZonedDateTime.of(dateTime1, zone);
		
		System.out.println("zone US/Eastern: " + zone);
		System.out.println("ZonedDateTime (int year, int month, int dayOfMonth, int hour, int second, int nanos, ZoneId zone): " + zone1);
		System.out.println("ZonedDateTime (LocalDate date, LocalTime time, ZoneId zone): " + zone2);
		System.out.println("ZonedDateTime (LocalDateTime dateTime, ZoneId zone): " + zone3);
		
		System.out.println("-------------------------------------------");
		
		var date = LocalDate.of(2022, Month.JANUARY, 20);
		System.out.println("LocalDate (int year, Month month, int dayOfMonth: "+ date);
		date = date.plusDays(2);
		System.out.println("plusDays: " + date);
		date = date.plusWeeks(1);
		System.out.println("plusWeeks: " + date);
		date = date.plusMonths(1);
		System.out.println("plusMonths: " + date);
		date = date.plusYears(5);
		System.out.println("plusYears: " + date);
		
		System.out.println("-------------------------------------------");
		
		var date4 = LocalDate.of(2024, Month.JANUARY, 20);
		var time4 = LocalTime.of(5,  15);
		var dateTime7 = LocalDateTime.of(date4, time4);
		System.out.println("LocalDateTime: " + dateTime7);
		dateTime7 = dateTime7.minusDays(1);
		System.out.println("minusDays: " + dateTime7);
		dateTime7 = dateTime7.minusHours(10);
		System.out.println("minusHours: " + dateTime7);
		dateTime7 = dateTime7.minusSeconds(30);
		System.out.println("minusSeconds: " + dateTime7);
		
		System.out.println("-------------------------------------------");
		var date5 = LocalDate.of(2024, Month.JANUARY, 20);
		var time5 = LocalTime.of(5, 15);
		var dateTime8 = LocalDateTime.of(date5, time5).minusDays(1).minusHours(10).minusSeconds(30);
		System.out.println("Chained minusDays, minusHours, minusSeconds: " + dateTime8);
		
		System.out.println("-------------------------------------------");
		var start = LocalDate.of(2022, Month.JANUARY, 1);
		var end = LocalDate.of(2022, Month.MARCH, 30);
		performAnimalEnrichment(start, end);
		
		System.out.println("-------------------------------------------");
		var period = Period.ofMonths(1); // Create a period
		performAnimalEnrichment(start, end, period);
		
		System.out.println("-------------------------------------------");
		var annually = Period.ofYears(1); // every 1 year
		var quarterly = Period.ofMonths(3); // every 3 years
		var everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
		var everyOtherDay = Period.ofDays(2); // every 2 days
		var everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days
		
		System.out.println("Period.ofYears - every one year: " + annually);
		System.out.println("Period.ofMonths - every 3 years: " + quarterly);
		System.out.println("Period.ofWeeks - every 3 weeks: " + everyThreeWeeks);
		System.out.println("Period.ofDays - every 2 days: " + everyOtherDay);
		System.out.println("Period.of(Year, month, days) - every year and 7 days : " + everyYearAndAWeek);
		
		System.out.println("-------------------------------------------");
		
		var date6 = LocalDate.of(2022, 1, 20);
		var time6 = LocalTime.of(6,  15);
		var dateTime9 = LocalDateTime.of(date6, time6);
		var period1 = Period.ofMonths(1);
		System.out.println("Adding period to LocalDate using plus(): "+ date6.plus(period1));
//		System.out.println("Adding period to LocalTime using plus(): " + time6.plus(period1)); // Exception
		System.out.println("Adding period to LocalDateTime using plus(): " + dateTime9.plus(period1));
		
		System.out.println("-------------------------------------------");
		
		var daily = Duration.ofDays(1);
		var hourly = Duration.ofHours(1);
		var everyMinute = Duration.ofMinutes(1);
		var everyTenSeconds = Duration.ofSeconds(10);
		var everyMilli = Duration.ofMillis(1);
		var everyNano = Duration.ofNanos(1);
		
		System.out.println("Duration ofDays: " + daily);
		System.out.println("Duration ofHours: " + hourly);
		System.out.println("Duration ofMinutes: " + everyMinute);
		System.out.println("Duration ofSeconds: " + everyTenSeconds);
		System.out.println("Duration ofMillis: " + everyMilli);
		System.out.println("Duration ofNanos: " + everyNano);
		
		/*
		 *  Duration ofDays: PT24H
			Duration ofHours: PT1H
			Duration ofMinutes: PT1M
			Duration ofSeconds: PT10S
			Duration ofMillis: PT0.001S
			Duration ofNanos: PT0.000000001S
		 */
		System.out.println("-------------------------------------------");
		
		daily = Duration.of(1,  ChronoUnit.DAYS);
		hourly = Duration.of(1, ChronoUnit.HOURS);
		everyMinute = Duration.of(1, ChronoUnit.MINUTES);
		everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
		everyMilli = Duration.of(1, ChronoUnit.MILLIS);
		everyNano = Duration.of(1, ChronoUnit.NANOS);
		
		System.out.println("Duration ChronoUnit.DAYS: " + daily);
		System.out.println("Duration ChronoUnit.HOURS: " + hourly);
		System.out.println("Duration ChronoUnit.MINUTES: " + everyMinute);
		System.out.println("Duration ChronoUnit.SECONDS: " + everyTenSeconds);
		System.out.println("Duration ChronoUnit.MILLIS: " + everyMilli);
		System.out.println("Duration ChronoUnit.NANOS: " + everyNano);
		
		System.out.println("-------------------------------------------");
		
		var one = LocalTime.of(5, 15);
		var two = LocalTime.of(6, 30);
		var date8 = LocalDate.of(2016, 1, 20);
		
		System.out.println("ChronoUnit.HOURS.between temporal unit 1 and unit2: " + ChronoUnit.HOURS.between(one, two));
		System.out.println("ChronoUnit.MINUTES between temporal units: " + ChronoUnit.MINUTES.between(one, two));
//		System.out.println("ChronoUnit.MINUTES between temporal units: " + ChronoUnit.MINUTES.between(one, date)); // DateTimeException
	
		System.out.println("-------------------------------------------");
		
		LocalTime time = LocalTime.of(3,  12, 45);
		LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES);
		System.out.println("LocalTime: " + time);
		System.out.println("truncatedTime: " + truncated);
		
		System.out.println("-------------------------------------------");
		
		var date9 = LocalDate.of(2022, 1, 20);
		var time9 = LocalTime.of(6, 15);
		var datetime9 = LocalDateTime.of(date, time);
		var duration = Duration.ofHours(6);
		
		System.out.println("DateTime and duration: " + dateTime9.plus(duration));
		System.out.println("time plus duration: " + time9.plus(duration));
//		System.out.println("date and duration: " + date9.plus(duration)); // UnsupportedTemporalTypeException
		
		System.out.println("-------------------------------------------");
		
		var date10 = LocalDate.of(2022, 1, 20);
		var time10 = LocalTime.of(6, 15);
		var dateTime10 = LocalDateTime.of(date10, time10);
		var duration1 = Duration.ofHours(23);
		
		System.out.println("DateTime plus duration: " + dateTime10.plus(duration1));
		System.out.println("time plus duration: " + time10.plus(duration1));
		System.out.println("Date plus duration: "+ date10.plus(duration));
		
		System.out.println("-------------------------------------------");
		
		//Period vs duration
		var date11 = LocalDate.of(2022, 5, 25);
		var period11 = Period.ofDays(1);
		var days = Duration.ofDays(1);
		
		System.out.println("date with period: " + date11.plus(period));
		System.out.println("date with duration: " + date11.plus(days)); // Unsupported unit: Seconds
		
		System.out.println("-------------------------------------------");
		
		var now = Instant.now();
		var later = Instant.now();
		var duration2 = Duration.between(now, later);
		System.out.println(duration.toMillis()); // returns number of milliseconds
		
		System.out.println("-------------------------------------------");
		
		var date12 = LocalDate.of(2022, 5, 25);
		var time12 = LocalTime.of(11, 55, 00);
		zone = ZoneId.of("US/Eastern");
		var zonedDateTime = ZonedDateTime.of(date, time, zone);
		var instant = zonedDateTime.toInstant();
		
		System.out.println("ZonedDateTime: " + zonedDateTime);
		System.out.println("Instant: " + instant);
		
		System.out.println("-------------------------------------------");
		
		var date13 = LocalDate.of(2022, Month.MARCH, 13);
		var time13 = LocalTime.of(1,  30);
		zone = ZoneId.of("US/Eastern");
		var dateTime13 = ZonedDateTime.of(date13, time13, zone);
		System.out.println("DateTime: " + dateTime13);
		System.out.println("DateTime hour: " + dateTime13.getHour());
		System.out.println("DateTime offset: " + dateTime13.getOffset());
		dateTime13 = dateTime13.plusHours(1);
		System.out.println("DateTime after adding 1 hour: " + dateTime13);
		System.out.println("DateTime hour: " + dateTime13.getHour());
		System.out.println("DateTime offset: " + dateTime13.getOffset());
		
		System.out.println("-------------------------------------------");
		
	}
	static void performAnimalEnrichment(LocalDate start, LocalDate end) {
		var upTo = start;
		while (upTo.isBefore(end)) {
			upTo = upTo.plusMonths(1);
		}
		System.out.println("adding months using plusMonths: " + upTo);
	}
	static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
		var upTo = start;
		while (upTo.isBefore(end)) {
			upTo = upTo.plus(period);
		}
		System.out.println("Adding months by creating Period: "+ upTo);
	}
}
