package com.ag.trycatch_;

public class OtherMethodException {
	public static void main(String[] args) {
		start();
	}

	private static void start() {
		getExc();
		System.out.println("start method ended");
	}


	static void getExc(){
		throw new ClassCastException();
	}
}


