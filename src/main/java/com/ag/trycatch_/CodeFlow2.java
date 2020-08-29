package com.ag.trycatch_;

public class CodeFlow2 {
	public static void main(String[] args) {
		String str = "";
		String str2 = null;

		if(str.isEmpty()) {
			throw new IllegalArgumentException();
		}if(str2 == null){
			throw new IllegalStateException();
		}

		System.out.println("go on");

	}
}
