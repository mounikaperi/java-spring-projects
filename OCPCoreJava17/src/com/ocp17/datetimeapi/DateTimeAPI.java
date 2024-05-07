package com.ocp17.datetimeapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeAPI {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		LocalTime appStartTime = LocalTime.now();
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate today = LocalDate.now();
		
		System.out.println("Today is " + today.format(dateFormat));
		
		System.out.println("Date of Birth i('dd-MMM-yyyy'): ");
		String dobStr = scan.next();
		LocalDate dob = LocalDate.parse(dobStr, dateFormat);
		
		Period age = Period.between(dob, today);
		System.out.println("You are " + age.getYears()+ " years " + age.getMonths() + " month and " + age.getDays() + " days of age");
		
		final int retirementAge = 70;
		LocalDate retirementDate = dob.plusYears(retirementAge);
		System.out.println("You can retire on: " + retirementDate.format(dateFormat));
		
		LocalTime appEndTime = LocalTime.now();
		Duration executionDuration = Duration.between(appStartTime, appEndTime);
		System.out.println("It took " + executionDuration.toNanos() + "nano seconds to execute");
		
		scan.close();
	}
}
