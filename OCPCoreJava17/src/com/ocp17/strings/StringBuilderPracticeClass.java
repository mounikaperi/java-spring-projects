package com.ocp17.strings;

public class StringBuilderPracticeClass {

	public static void main(String[] args) {
		String alpha = "";
		for (char current='a'; current<='z'; current++) {
			alpha+= current; // 26 new strings are created- hence use StringBuilder
		}
		System.out.println(alpha);
		
		StringBuilder a = new StringBuilder();
		for (char current='a'; current<='z'; current++) {
			a.append(current);
		}
		System.out.println(a);
		
		System.out.println("---------------------------------------------------------");
		StringBuilder sb = new StringBuilder("start");
		sb.append("+middle");
		StringBuilder same = sb.append("+end");
		System.out.println(sb);
		System.out.println(same);
		
		System.out.println("---------------------------------------------------------");
		StringBuilder b = new StringBuilder("abc");
		StringBuilder c = b.append("de");
		c = c.append("f").append("g");
		System.out.println(b); // abcdefg
		System.out.println(c); // abcdefg
		
		System.out.println("---------------------------------------------------------");
		
	}

}
