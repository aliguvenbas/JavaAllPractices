package com.ag.java8lambdabasics;

import java.util.function.Consumer;

public class ThisKeywordUsage {
	private Integer x = new Integer(5);

	private void doSth(int i, Consumer<Integer> c) {
		c.accept(i);
		System.out.println("this1:" + this);
	}

	public static void main(String[] args) {

		ThisKeywordUsage usage = new ThisKeywordUsage();
		// inner class implementation
		usage.doSth(10, new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("t:" + t);
				System.out.println("this2:" + this);
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Inner Class toString() method" + super.toString();
			}
		});

		// xxx Lambda expression
		usage.doSth(11, t -> {
			System.out.println("t:" + t);
			// System.out.println("this:" + this);// --> Cannot use in a static
			// context
			// Lambda expression is not an inner class by design
			// this keyword in here still refer a static method, proper use in doSthInClass()
		});
		usage.doSthInClass(usage);
	}

	private void doSthInClass(ThisKeywordUsage usage) {
		// +++ Lambda expression
		usage.doSth(12, t -> {
			System.out.println("t:" + t);
			System.out.println("this3:" + this);//it refers ThisKeywordUsage object
		});

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Main Class toString() method" + super.toString();
	}

}
