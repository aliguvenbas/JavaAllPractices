package com.ag.this_;

/*
 *  - Within an instance method or a constructor, this is a reference to the current object
 *  - Printing 'this' keyword means printing toString() method
 */
public class ThisUsage {

	public static void main(String[] args) {
		// xxx this can not be used in static method, because static method is
		// not a object reference.
		// System.out.println(this);
		ThisUsage thisUsage = new ThisUsage();
		thisUsage.printSth();
	}

	private void printSth() {
		// +++ this keyword is refer a ThisUsage object
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "This keyword refers toString() method of object";
	}

}
