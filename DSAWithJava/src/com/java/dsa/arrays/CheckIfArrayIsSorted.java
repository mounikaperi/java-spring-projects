package com.java.dsa.arrays;

class CheckIfArrayIsSorted {
    public static void main(String[] args) {
       int arr[] = {1, 2, 3, 4, 5, 9, 8};
       System.out.println("Is array sorted: " + isArraySorted(arr));
    }
    static boolean isArraySorted(int[] arr) {
        // If no elements present or only one element present in array- consider it a sorted
        if (arr.length == 0 || arr.length == 1) return true;
        // If first element is greater than second element - array is not sorted
	    // If first element is equal to second element - consider array is sorted - proceed with next loop
        for (int i=0; i<arr.length-1; i++) 
            if (arr[i] > arr[i+1] && arr[i] != arr[i+1]) return false;
        return true; 
    }
}
