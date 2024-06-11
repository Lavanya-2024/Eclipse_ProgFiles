//Java program to Reverse a String 
package com.springboot.jpa.Util.practicalProgrammes;



public class ReverseString {

	public static String reversestring(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}	

		String reservestring = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reservestring = reservestring + str.charAt(i);
		}
		return reservestring;
	}

	public static void main(String[] args) {
		java.lang.String name = "Lavanya";

		// Java program to Reverse a String by using toCharArray

		char[] chararray = name.toCharArray();
		// System.out.println(chararray.length);

		for (int i = chararray.length - 1; i >= 0; i--) {
			System.out.print(chararray[i]);
		}
		System.out.println("=========================================");
		// Java program to Reverse a String by using charAt
		for (int i = name.length() - 1; i >= 0; i--) {
			char ch = name.charAt(i);
			String str = ch + "";
			System.out.print(str);
		}
		System.out.println("=========================================");
		// Java program to Reverse a String without predefined method

		String str2 = "java";
		String reverse = reversestring(str2);
		System.out.println("Reversed string: " + reverse);
	}

}
