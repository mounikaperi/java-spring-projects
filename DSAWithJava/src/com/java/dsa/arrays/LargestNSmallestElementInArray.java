package com.java.dsa.arrays;

import java.util.Scanner;

public class LargestNSmallestElementInArray {

	public static void main(String[] args) {
		/**
		 * Given an array 'arr' of size 'n' find the largest element
		 * Input: 'n' = 5, 'arr' = [1, 2, 3, 4, 5]
		 * Output: 5
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array: ");
		int length = sc.nextInt();
		System.out.println("Enter the array of elements");
		int array[] = new int[length];
		for (int i=0; i<length; i++) {
			array[i] = sc.nextInt();
		}
		int largestElement = findLargestElement(length, array);
		int smallestElement = findSmallestElement(length, array);
		System.out.println("Largest element in array is: " + largestElement);
		System.out.println("Smallest element in array is: " + smallestElement);
	}
	static int findLargestElement(int length, int[] array) {
		int largest = array[0];
		for (int n : array) {
			if (n > largest) {
				largest = n;
			}
		}
		return largest;
	}
	static int findSmallestElement(int length, int[] array) {
		int smallest = array[0];
		for (int n : array) {
			if (n < smallest) {
				smallest = n;
			}
		}
		return smallest;
	}
}
