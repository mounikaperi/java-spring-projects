package com.java.dsa.binarysearch;

import java.util.Scanner;

public class SearchForTheTargetValue {

	public static void main(String[] args) {
		/**
		 * You are given with sorted arry 'arr' of distinct values and a target value 'm'
		 * You need to search for the index of the target value in the array
		 * If the element is not present, return the index where it has to be inserted
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of the array: ");
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the target element: ");
		int target = sc.nextInt();
		System.out.println("Element found at or element to be inserted at: " + findTargetElement(arr, 0, (arr.length-1), target));
	}
	static int findTargetElement(int[] arr, int low, int high, int target) {
		int ans = high + 1;
		if (low > high) return ans;
		int mid = (low + ((high-low)/2));
		if (arr[mid] >= target) {
			ans = mid;
			ans = findTargetElement(arr, low, mid-1, target);
		} else {
			ans = findTargetElement(arr, mid+1, high, target);
		}
		return ans;
	}
}
