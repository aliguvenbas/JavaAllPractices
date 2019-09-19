package com.ag.interview_;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

public class Practice {

	public static void main(String[] args) {
		// HashMap
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Test1");
		map.put(2, "Test2");

		// StringBuffer StringBuilder
		String[] words = new String[] { "z", "a", "m", "a", "n" };
		StringBuffer strBuffer = new StringBuffer();
		for (String letter : words) {
			strBuffer.append(letter);
		}
		System.out.println(strBuffer);

		// ch1_1();

		ch1_2();
		
		ch2_1();
		
		ch1_3();

	}

	private static void ch1_3() {
		ch1_3 ch1_3 = new ch1_3();
		ch1_3.removeDuplicetes("merhabalar");
	}

	private static void ch2_1() {

		LinkedList<String> linkedList = new LinkedList<>();
	}

	public static void ch1_1() {
		// Implement an algorithm to determine if a string has all unique
		// characters. What if you can not use additional data structures?????
		// String str = "çanakkale";
		// char[] array = str.toCharArray();
		// char[] uniqArray = new char[array.length];
		//
		// int lastIndex = 0;
		// for (int i = 0; i < array.length; i++) {
		// for (int y = 0; y < uniqArray.length; y++) {
		// if ( uniqArray[y] == array[i]) {
		// break;
		// } else if(uniqArray[lastIndex] == ""){
		// uniqArray[lastIndex] = array[i];
		// lastIndex++;
		// break;
		// }
		// }
		// }
		// System.out.println(String.valueOf(uniqArray));
	}

	public static void ch1_2() {
		// Write code to reverse a C-Style String. (C-String means that “abcd”
		// is represented as five characters, including the null character.)
		System.out.println("Write code to reverse a C-Style String");
		String str = "fdsafdsav avdsavd GAFDSAVD";
		StringBuffer reverse = new StringBuffer();

		int i = str.length() - 1;
		do {
			reverse.append(str.charAt(i));
			i--;
		} while (i >= 0);

		// for (int i = str.length()-1; i >= 0; i--) {
		// reverse.append(str.charAt(i));
		// }
		System.out.println(reverse);
	}

}
