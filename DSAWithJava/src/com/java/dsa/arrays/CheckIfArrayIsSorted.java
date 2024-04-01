package com.java.dsa.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CheckIfArrayIsSorted {

	public static void main(String[] args) {
		/**
		 * You have been given an array ‘a’ of ‘n’ non-negative integers.
		 * You have to check whether the given array is sorted in the non-decreasing order or not.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array:");
		int length = sc.nextInt();
		System.out.println("Enter the array of elements:");
		int[] array = new int[length];
		for (int i=0; i<length; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println(isArraySorted(length, array));
	}
	
	static int isArraySorted(int length, int[] array) {
		if (length == 0 || length == 1) {
			// If no elements entered or only one element present in array- consider it a sorted
			return 1;
		}
		for (int i=0; i<length-1; i++) {
			if (array[i] > array[i+1] && array[i] != array[i+1]) {
				// If first element is greater than second element - array is not sorted
				// If first element is equal to second element - consider array is sorted - proceed with next loop
				return 0;
			}
		}
		return 1;
	}

}
