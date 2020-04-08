package com.ag.collections_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SearchingTimeTestWithTwoArray {


	public static void main(String[] args) {
		List<Integer> list1  = new ArrayList<>();
		List<Integer> list2  = new ArrayList<>();

		Random random = new Random();
		random.ints(10000,1,100).forEach(i -> list1.add(i));

		random.ints(10,1,100 ).forEach(i -> list2.add(i));
//
//		for(int i = 0; i< 10000; i++){
//			list1.add((int)Math.random());
//		}
//
//		for(int i = 0; i< 10; i++){
//			list1.add((int)Math.random());
//		}

		Long t1 = System.currentTimeMillis();
		list1.stream().anyMatch(number -> {System.out.print(number+",");
		return list2.contains(number);});
		Long t2 = System.currentTimeMillis();
		System.out.println("\n Time 1: "+(t2-t1));

		t1 = System.currentTimeMillis();
		for(Integer i : list1){
			System.out.print(i+",");
			if(list2.contains(i)){
				System.out.println("found:"+i);
				break;
			}
		}
		t2 = System.currentTimeMillis();
		System.out.println("\nTime 11: "+(t2-t1));





		 t1 = System.currentTimeMillis();
		list2.stream().anyMatch(number -> {System.out.print(number+",");
			return list1.contains(number);});
		 t2 = System.currentTimeMillis();

		System.out.println("\nTime 2: "+(t2-t1));
		t1 = System.currentTimeMillis();
		for(Integer i : list2){
			System.out.print(i+",");
			if(list1.contains(i)){
				System.out.println("found:"+i);
				break;
			}
		}
		t2 = System.currentTimeMillis();
		System.out.println("\nTime 22: "+(t2-t1));



	}


}
