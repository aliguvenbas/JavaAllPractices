package com.ag.trycatch_;

public class CodeFlow {

	public static void main(String[] args) {
		String str = null;

		try {
			int size = str.length();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}

		System.out.println("go on");

	}

}
