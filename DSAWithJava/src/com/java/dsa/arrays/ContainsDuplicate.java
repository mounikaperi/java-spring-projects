/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Example 1:
Input: nums = [1,2,3]
Output: true
*/
import java.util.Arrays;

class ContainsDuplicate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 1};
        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.containsDuplicate(arr));
    }
    static boolean containsDuplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++)
           if (arr[i] == arr[i+1]) return true;
        return false;
    }
}
