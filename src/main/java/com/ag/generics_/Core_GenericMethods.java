package com.ag.generics_;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Core_GenericMethods {


	//#Original
//	public int getCount(Collection<String> array, String item) {
//		int count = 0;
//
//		if(item == null) {
//			for(String s : array) {
//				if(s == null) {
//					count++;
//				}
//			}
//		} else {
//			for(String s : array) {
//				if(item.equals(s)) {
//					count++;
//				}
//			}
//		}
//
//		return count;
//	}

	//#Generic 1
	public static <T> int getCount(Collection<T> col, T item) {
		int count = 0;

		if(item == null) {
			for(T element : col) {
				if(element == null) {
					count++;
				}
			}
		} else {
			for(T element : col) {
				if(item.equals(element)) {
					count++;
				}
			}
		}

		return count;

	}

	//#Generic 2
	public static <T extends Number> int getCount_BoundedTypeParameter(Collection<T> col, T item) {
		int count = 0;

		if(item == null) {
			for(T element : col) {
				if(element == null) {
					count++;
				}
			}
		} else {
			for(T element : col) {
				if(item.equals(element)) {
					count++;
				}
			}
		}

		return count;

	}

	//#Generic 3
	public static int getCount_BoundedWildCard(Collection<? extends Number> col, Number item) {
		int count = 0;

		if(item == null) {
			for(Number element : col) {
				if(element == null) {
					count++;
				}
			}
		} else {
			for(Number element : col) {
				if(item.equals(element)) {
					count++;
				}
			}
		}

		return count;

	}


	@Test
	public void useTypeParametersAtMethod() {
		List<String> helloWorld = Arrays.asList("h", "e", "l", "l", "o", "w", "o", "r", "l", "d");
		int count = getCount(helloWorld, "l");
		System.out.println("#occurrences of l: " + count);
	}

	@Test
	public void useTypeParametersAtMethodWithBoundedTypeParameter() {
		List<String> helloWorldString = Arrays.asList("h", "e", "l", "l", "o", "w", "o", "r", "l", "d");
		List<Integer> helloWorldInteger = Arrays.asList(1, 34, 66, 76, 2, 1);
		//		int count = getCount_BoundedTypeParameter(helloWorldString, "l");//this methods accept only object list that extends Number
		int count = getCount_BoundedTypeParameter(helloWorldInteger, 1);
		System.out.println("#occurrences of l: " + count);
	}

	@Test
	public void useBoundedWildcardInGenericMethod(){
		List<Integer> helloWorldInteger = Arrays.asList(1, 34, 66, 76, 2, 1);
		int count = getCount_BoundedWildCard(helloWorldInteger, 1);
		System.out.println("#occurrences of l: " + count);
	}
}
