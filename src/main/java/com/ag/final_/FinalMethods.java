package com.ag.final_;

public class FinalMethods {
	public final static int count = 20;// Final olan bir sınıf değişkenine
										// sadece bir kere değer ataması
										// yapilabilir ve bu atama sadece sınıf
										// konstrüktöründe gerçekleşebilir.
	
	public final void  finalMethod() {//Override edilemez
		System.out.println("final Method");
	}
	
	public void  normalMethod() {
		System.out.println("normal Method");
	}

	public static void main(String[] args) {
//		count = 30;
	}
}
