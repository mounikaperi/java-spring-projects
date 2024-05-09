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
		
		System.out.println(date1);
		System.out.println(date2);
		 
		/*
		 * 2022-01-20
		   2022-01-20
		 */
		
		System.out.println("-------------------------------------------");
		var time1 = LocalTime.of(6, 15);
		var time2 = LocalTime.of(6, 15, 30);
		var time3 = LocalTime.of(6,  15, 30, 200);
		
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		
		/*
		 *  06:15
			06:15:30
			06:15:30.000000200
		 */
		System.out.println("-------------------------------------------");
		var dateTime1 = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
		var dateTime2 = LocalDateTime.of(date1, time1);
		System.out.println(dateTime1);
		System.out.println(dateTime2);
		
		System.out.println("-------------------------------------------");
		var zone = ZoneId.of("US/Eastern");
		var zone1 = ZonedDateTime.of(date1, time1, zone);
		
		
		
	}

}
