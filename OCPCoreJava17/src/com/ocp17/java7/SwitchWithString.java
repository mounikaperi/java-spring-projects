package com.ocp17.java7;

public class SwitchWithString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayTodayDetails();
		displayWeekDetails();
	}
	private static void displayTodayDetails() {
		String input = "Wednesday";
		switch(input) {
			case "Monday":
				System.out.println("Today is Monday");
				break;
			case "Tuesday":
				System.out.println("Today is Tuesday");
				break;
			case "Wednesday":
				System.out.println("Today is Wednesday");
				break;
			case "Thursday":
				System.out.println("Today is Thursday");
				break;
			case "Friday":
				System.out.println("Today is Friday");
				break;
			case "Saturday":
				System.out.println("Today is Saturday");
				break;
			case "Sunday":
				System.out.println("Today is Sunday");
				break;
		}
	}
	private static void displayWeekDetails() {
		String input = "Saturday";
		switch (input) {
			case "Monday":
			case "Tuesday":
			case "Wednesday":
			case "Thursday":
			case "Friday":
				System.out.println("Today is weekday");
				break;
			case "Saturday":
			case "Sunday":
				System.out.println("Today is weekend");
				break;
			default:
				System.out.println("Today is Holiday");
		}
	}
}
