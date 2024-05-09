package com.ocp17.datetimeapi;

import java.time.*;


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
