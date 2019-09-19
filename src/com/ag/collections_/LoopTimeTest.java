package com.ag.collections_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ag.java8lambdabasics.FootballPlayer;

public class LoopTimeTest {

	public static void main(String[] args) {

		List<DummyLoopElement> list = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			list.add(new DummyLoopElement(Math.random(), "Test:" + Math.random(), Math.random()));
		}

		// for loop
		Long t1 = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Obj1:" + (Double) list.get(i).getObject1() + ", Obj2:" + (String) list.get(i).getObject2() + ", Obj1+Obj3:" + ((Double) list.get(i).getObject1() + (Double) list.get(i).getObject3()));
		}
		Long t2 = System.currentTimeMillis();

		// for-each / for-in loop
		Long t3 = System.currentTimeMillis();
		for (DummyLoopElement dummyLoopElement : list) {
			System.out.println("Obj1:" + (Double) dummyLoopElement.getObject1() + ", Obj2:" + (String) dummyLoopElement.getObject2() + ", Obj1+Obj3:" + ((Double) dummyLoopElement.getObject1() + (Double) dummyLoopElement.getObject3()));
		}
		Long t4 = System.currentTimeMillis();

		// lambda for-each loop
		Long t5 = System.currentTimeMillis();
		list.forEach(dummyLoopElement -> System.out.println("Obj1:" + (Double) dummyLoopElement.getObject1() + ", Obj2:" + (String) dummyLoopElement.getObject2() + ", Obj1+Obj3:" + ((Double) dummyLoopElement.getObject1() + (Double) dummyLoopElement.getObject3())));
		Long t6 = System.currentTimeMillis();

		System.out.println("for loop:" + (t2 - t1) + "ms \n");
		System.out.println("for-each / for-in loop:" + (t4 - t3) + "ms \n");
		System.out.println("lambda for-each loop:" + (t6 - t5) + "ms \n");

	}

}
