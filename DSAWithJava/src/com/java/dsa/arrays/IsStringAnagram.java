/**
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
*/
import java.util.Arrays;

class IsStringAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        IsAnagram obj = new IsAnagram();
        System.out.println(obj.isStringAnagram(s, t));
    }
    static boolean isStringAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] store = new int[26];
        for (int i=0; i<s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }
        for (int n: store) if (n != 0) return false;
        return true;
    }
}
