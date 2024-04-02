package com.java.dsa.binarysearch;

import java.util.Scanner;

public class UpperBound {

	public static void main(String[] args) {
		/**
		 * Given an sorted array and a number 'x'. return the upper bound of 'x'
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of the array: ");
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the element for which lower bound has to be calculated: ");
		int target = sc.nextInt();
		System.out.println("Upper bound of element is: " + findUpperBound(arr, 0, (arr.length-1), target));
	}
	static int findUpperBound(int[] arr, int low, int high, int target) {
		int ans = high + 1;
		if (low > high) return ans;
		int mid = (low + ((high-low)/2));
		if (arr[mid] > target) {
			ans = mid;
			ans = findUpperBound(arr, low, mid-1, target);
		} else {
			ans = findUpperBound(arr, mid+1, high, target);
		}
		return ans;
	}

}
