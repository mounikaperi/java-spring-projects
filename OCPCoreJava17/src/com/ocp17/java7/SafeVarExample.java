package com.ocp17.java7;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SafeVarExample {

	public static void main(String[] args) {
		sum(1);
		sum(1, 2);
		sum(1, 2, 3);
		SafeVarExample object = new SafeVarExample();
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		list1.add("java");
		list2.add("java7");
		list3.add("java8");
		object.print(list1, list2, list3);
	}
	@SafeVarargs
	public final void print(List<String>... lists) {
		String firstName = lists[0].get(0);
		System.out.println(firstName);
	}
	public static void sum(int... nums) {
		System.out.println(Arrays.toString(nums));
		int sum = 0;
		for (int num: nums) {
			sum += num;
		}
		System.out.println("The total sum of the given input is: " + sum);
	}
}
