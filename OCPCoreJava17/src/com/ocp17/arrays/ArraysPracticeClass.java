package com.ocp17.arrays;

import java.util.Arrays;

public class ArraysPracticeClass {

	public static void main(String[] args) {
		String[] bugs = {"cricket", "beetle", "ladybug"};
		String[] alias = bugs;
		System.out.println(bugs.equals(alias)); // true
		System.out.println(bugs.toString()); // [Ljava.lang.String;@79fc0f2f
		
		System.out.println("---------------------------------------------");
		String[] strings = { "stringValue" };
		Object[] objects = strings;
		String[] againStrings = (String[]) objects;
//		againStrings[0] = new StringBuilder(); // Doesnt compile
//		objects[0] = new StringBuilder();
		
		System.out.println("---------------------------------------------");
		String[] mammals = {"monkey", "chimp", "donkey"};
		System.out.println(mammals.length);
		System.out.println(mammals[0]);
		System.out.println(mammals[1]);
		System.out.println(mammals[2]);
		
		System.out.println("---------------------------------------------");
		int[] numbers = {6, 8, 9, 1, 5, 3};
		Arrays.sort(numbers);
		for (int i=0;i<numbers.length; i++) 
			System.out.print(numbers[i] + " ");
		
		System.out.println();
		System.out.println("---------------------------------------------");
		String[] s = {"10", "9", "100"};
		Arrays.sort(s);
		for(String a: s)
			System.out.print(a + " ");
		
		System.out.println();
		System.out.println("---------------------------------------------");
	}

}
