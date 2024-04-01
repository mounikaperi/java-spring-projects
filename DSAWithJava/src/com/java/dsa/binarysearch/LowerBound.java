package com.java.dsa.binarysearch;

import java.util.Scanner;

public class LowerBound {

	public static void main(String[] args) {
		/**
		 * Given an sorted array and a number 'x'. return the lower bound of 'x'
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
		System.out.println("Lower bound of element is: " + findLowerBound(arr, 0, (arr.length-1), target));
	}
	static int findLowerBound(int[] arr, int low, int high, int target) {
		int ans = high + 1; // size of array
		if (low > high) return ans;
		int mid = (low + high)/2;
		if (arr[mid] >= target) {
			ans = mid;
			ans = findLowerBound(arr, low, mid-1, target);
		} else {
			ans = findLowerBound(arr, mid+1, high, target);
		}
		return ans;
	}

}
