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
		var d = new StringBuilder("animals");
		String sub = d.substring(d.indexOf("a"), d.indexOf("al"));
		int length = d.length();
		char ch = d.charAt(6);
		System.out.println(sub + " " + length + " " + ch);
		
		System.out.println("---------------------------------------------------------");
		var e = new StringBuilder().append(1).append('c');
		e.append("-").append(true);
		System.out.println(e);
		
		System.out.println("---------------------------------------------------------");
		var f = new StringBuilder("animals");
		f.insert(7, "-");    // animals-
		f.insert(0,  "-");   // -animals-
		f.insert(4, "-");	 // -ani-mals-
		System.out.println(f);
		
		System.out.println("---------------------------------------------------------");
		var g = new StringBuilder("abcdef");
		g.delete(1,  3); // abef
//		g.deleteCharAt(5); // Exception
		
		System.out.println("---------------------------------------------------------");
		var builder = new StringBuilder("pigeon dirty");
		builder.replace(3,  6,  "sty");
		System.out.println(builder); // pigsty dirty
		
		builder = new StringBuilder("pigeon dirty");
		builder.replace(3, 100, ""); // pig
		System.out.println(builder);
		
		System.out.println("---------------------------------------------------------");
		sb = new StringBuilder("abc");
		sb.reverse();
		System.out.println(sb);
		
		System.out.println("---------------------------------------------------------");
		var one = new StringBuilder();
		var two = new StringBuilder();
		var three = one.append("a");
		System.out.println(one == two); // false
		System.out.println(one == three); // true
		
		System.out.println("---------------------------------------------------------");
		var x = "Hello World";
		var z = "   Hello World   ".trim();
		System.out.println(x.equals(z)); // true
		
		var name = "a";
		builder = new StringBuilder("a");
//		System.out.println(name == builder); // Does not compile
		
		var h = "Hello World";
		var i = "Hello World";
		System.out.println(h == i); // true	
		
		var j = "Hello World";
		var k = "  Hello  World  ".trim();
		System.out.println(j == k); // false
		
		var singleString = "hello world";
		var concat = "hello ";
		concat += "world";
		System.out.println(singleString == concat); // false
		
		var l = "Hello World"; // take from string pool if exists
		var m = new String("Hello World"); // create new string even if it exists in string pool
		System.out.println(l == m); //false
		
		var n = "Hello World"; // take from string pool if exists
		var o = new String("Hello World").intern(); // create new object using constructor but to intern it and use the string pool anyway
		System.out.println(n == o); 
		
		var first = "rat" + "1";
		var second = "r" + "a" + "t" + "1";
		var third = "r" + "a" + "t" + new String("1");
		System.out.println(first == second); // true
		System.out.println(first == second.intern()); // true
		System.out.println(first == third); // false
		System.out.println(first == third.intern()); // true
	}

}
