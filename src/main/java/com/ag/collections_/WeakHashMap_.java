package com.ag.collections_;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMap_ {

	public static void main(String args[]) throws Exception {
		HashMap hashMap = new HashMap();
		Demo demo1 = new Demo();

		hashMap.put(demo1, " Hi ");

		System.out.println(hashMap);
		demo1 = null;

		// garbage collector is called
		System.gc();

		//thread sleeps for 4 sec
		Thread.sleep(4000);
		System.out.println("hashMap:" + hashMap);

		System.out.println("----------------------------------------------------------------------------------");

		WeakHashMap weakHashMap = new WeakHashMap();
		Demo demo2 = new Demo();

		weakHashMap.put(demo2, " Hi ");
		System.out.println(weakHashMap);

		demo2 = null;

		// garbage collector is called
		System.gc();

		// thread sleeps for 4 sec
		Thread.sleep(4000);

		System.out.println("weakHashMap:" + weakHashMap);
	}
}

class Demo {
	public String toString() {
		return "demo";
	}

	public void finalize() {
		System.out.println("Finalize method is called");
	}
}

