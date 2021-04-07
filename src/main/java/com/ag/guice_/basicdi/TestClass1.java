package com.ag.guice_.basicdi;

import com.google.inject.Inject;

public class TestClass1 {
	private final TestClass2 testClass2;

	@Inject
	public TestClass1(TestClass2 testClass2) {
		this.testClass2 = testClass2;
	}

	public void printMsg(){
		System.out.println(testClass2.msg());
	}
}
