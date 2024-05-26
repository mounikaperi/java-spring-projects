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
		int[] a = {2, 4, 6, 8};
		System.out.println(Arrays.binarySearch(a, 2)); // 0
		System.out.println(Arrays.binarySearch(a, 4)); // 1
		System.out.println(Arrays.binarySearch(a, 1)); // -1
		System.out.println(Arrays.binarySearch(a, 3)); // -2
		System.out.println(Arrays.binarySearch(a, 9)); // -5
		
		System.out.println("---------------------------------------------");
		int[] b = { 4, 2, 8};
		System.out.println(Arrays.binarySearch(a, 2)); // 0
		System.out.println(Arrays.binarySearch(a, 4)); // 1
		
		System.out.println("---------------------------------------------");
		System.out.println(Arrays.compare(new int[] {1}, new int[] {2})); // -1
		System.out.println(Arrays.compare(new int[] {1, 2}, new int[] {1})); // 1 - the first element is same but the first array is longer
		System.out.println(Arrays.compare(new int[] {1, 2}, new int[] {1, 2})); // 0 - Exact Match
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"aa"})); // -1 - second array is longer
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"A"})); // 32 - uppercase is smaller than lower case
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {null})); // 1- null is smaller than "a"s
//		System.out.println(Arrays.compare(new int[] {1}, new String[] {"a"})); // Doesnt compile
		
		System.out.println("---------------------------------------------");
		System.out.println(Arrays.mismatch(new int[] {1}, new int[] {1})); // arrays are same hence -1
		System.out.println(Arrays.mismatch(new String[] {"a"}, new String[] {"A"})); //not equal - hence 0
		System.out.println(Arrays.mismatch(new int[] {1, 2}, new int[] {1})); // 1
		
		/**
		 * equals() -
		 * 		-> When arrays contain the same data - true
		 * 		-> When arrays are different - false
		 * compare() - 
		 * 		-> When arrays contain the same data - 0
		 * 		-> when arrays are different - positive or negative
		 * mismatch() -
		 * 		-> when arrays contain the same data - -1
		 * 		-> when arrays are different - zero or positive index
		 */
		
		System.out.println("---------------------------------------------");
	}

}
