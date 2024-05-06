package com.ocp17.generics;

public class Swapper<T> {
	
	public void doSwap(T a, T b) {
		System.out.println("Before Swapping: " + a + "\t" + b);
		T temp = a;
		a= b;
		b = temp;
		System.out.println("After Swapping: " + a + "\t" + b);
	}

	public static void main (String[] args) {
		Swapper<Integer> s1 = new Swapper<>();
		s1.doSwap(125, 675);
		
		Swapper<String> s2 = new Swapper<>();
		s2.doSwap("Hi", "Hello");
		
		Swapper<Character> s3 = new Swapper<>();
		s3.doSwap('@', '#');
	}
}
 