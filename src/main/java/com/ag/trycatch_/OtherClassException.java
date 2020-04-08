package com.ag.trycatch_;

public class OtherClassException {

	static OtherClass otherClassException = new OtherClass();

	public static void main(String[] args) {
		try {
			int size = otherClassException.getInt();
		} catch (NullPointerException | ClassCastException e) {
			e.printStackTrace();
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}

		System.out.println("go on");

	}

}
