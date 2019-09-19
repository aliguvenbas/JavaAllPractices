package com.ag.final_;

public class SubClass extends FinalMethods {

	// @Override
	// public void finalMethod() {// Final olan bir metot ne alt sınıflarca
	// yeniden
	// // yüklenebilir (method overloading) ne de saklı
	// // (hidden) tutulabilir.
	// System.out.println("final Method");
	// }

	public void finalMethod(int i) {
		System.out.println("final Method overload");
	}

	@Override
	public void normalMethod() {
		System.out.println("normal Method");
	}
}
