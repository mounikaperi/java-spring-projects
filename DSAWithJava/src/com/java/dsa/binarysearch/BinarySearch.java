package com.java.dsa.binarysearch;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		/**
		 * Given an integer array 'A' of size 'N' sorted in non-descending order.
		 * You are given an integer 'target'
		 * Write a function to search for target in the array. if it exists return index else return -1
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of the array: ");
		for (int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the element to search: ");
		int target = sc.nextInt();
		System.out.println("Element found at index: " + binarySearch(arr, 0, arr.length-1, target));
	}
	
	static int binarySearch(int[] arr, int low, int high, int target) {
		if (low > high) return -1;
		int mid = (low + (high - low)/2);
		if (arr[mid] == target) return mid;
		if (target > arr[mid]) return binarySearch(arr, mid+1, high, target);
		return binarySearch(arr, low, mid-1, target);
	}

}
