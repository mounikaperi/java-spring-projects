package com.dsa.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestNSecondSmallestElementInArray {

	public static void main(String[] args) {
		/**
		 * You have been given an array ‘a’ of ‘n’ unique non-negative integers.
		 * Find the second largest and second smallest element from the array.
		 * Return the two elements (second largest and second smallest) as another array of size 2.
		 * Input: ‘n’ = 5, ‘a’ = [1, 2, 3, 4, 5]
		 * Output: [4, 2]
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array:");
		int length = sc.nextInt();
		System.out.println("Enter the array of elements:");
		int[] array = new int[length];
		for (int i=0; i<length; i++) {
			array[i] = sc.nextInt();
		}
		int[] computedArray = new int[2];
		computedArray[0] = secondLargest(length, array);
		computedArray[1] = secondSmallest(length, array);
		System.out.println("Second Largest and Second Smallest elements are: " + Arrays.toString(computedArray));
	}
	
	static int secondLargest(int length, int[] array) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for (int n : array) {
			if (n > largest) {
				secondLargest = largest;
				largest = n;
			} else if (n > secondLargest && n != largest) {
				secondLargest = n;
			}
		}
		return secondLargest;
	}
	
	static int secondSmallest(int length, int[] array) {
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int n : array) {
			if (n < smallest) {
				secondSmallest = smallest;
				smallest = n;
			} else if (n < secondSmallest && n != smallest) {
				secondSmallest = n;
			}
		}
		return secondSmallest;
	}

}
