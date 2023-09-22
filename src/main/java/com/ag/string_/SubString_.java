package com.ag.string_;

public class SubString_ {

	public static void main(String[] args) {
		String str = "java substring examples";
		
		System.out.println(str.charAt(0) );
		
		System.out.println(str.toUpperCase());//all uppercase
		
		System.out.println(str.substring(0, 1).toUpperCase()+str.substring(1));//only first letter upper case

		str = null;

		String[] ts = str.split("t");

	}

}
