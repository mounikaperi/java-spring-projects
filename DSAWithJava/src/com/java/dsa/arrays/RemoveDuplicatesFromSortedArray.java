package com.java.dsa.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		/**
		 * You are given a sorted integer array 'arr' of size 'n'.
		 * You need to remove the duplicates from the array such that each element appears only once.
		 * Return the length of this new array.
		 * Do not allocate extra space for another array. You need to do this by modifying the given input array in place with O(1) extra memory. 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array:");
		int length = sc.nextInt();
		System.out.println("Enter the array of elements:");
		int[] array = new int[length];
		for (int i=0; i<length; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("Size of the array after removing duplicates: " + removeDuplicatesFromArray(array));
	}
	// [ 1, 2, 2, 1]
	static int removeDuplicatesFromArray(int[] array) {
		int i=0;
		for (int j=1; j<array.length; j++) {
			if (array[i] != array[j]) {
				// this implies subsequent elements are not same
				i++;
				array[i] = array[j];
			}
			// if elements are same - then continue with next iteration
		}
		return i+1;
	}
}
