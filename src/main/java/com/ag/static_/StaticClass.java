package com.ag.static_;

public class StaticClass {

	public static void main(String[] args) {
		TestClass.getTestClass();

		TestClass.getTestClass2();

	}
}

class TestClass {
	private static final TestClass testClass = new TestClass();

	private TestClass() {
		System.out.println("testtt");
	}

	public static TestClass getTestClass() {
		System.out.println("testtt22");
		return testClass;
	}

	public static TestClass getTestClass2() {
		System.out.println("testtt2233");
		return testClass;
	}
}
