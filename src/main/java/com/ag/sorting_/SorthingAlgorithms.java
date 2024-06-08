package com.ag.sorting_;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;


public class SorthingAlgorithms {

	@Test
	public void shouldSortWitSelectSort() {
		int[] array = {10, 7, 8, 6, 3};

		// O(n2) complexity
		for(int i = 0; i < array.length; i++) {
			int smallaestNumber = array[i];
			int minIndex = i;
			for(int s = i + 1; s < array.length; s++) {
				if(array[s] < smallaestNumber) {
					minIndex = s;
					smallaestNumber = array[s];
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}

		Arrays.stream(array).forEach(System.out::println);

		assertArrayEquals(array, new int[]{3, 6, 7, 8, 10});
	}

	@Test
	public void shouldSortWithInsertionSort() {
		int[] array = {10, 7, 8, 6, 3};

		for(int i = 1; i < array.length; i++) {// n complexity
			insertionSort(array, i);
		}

		Arrays.stream(array).forEach(System.out::println);

		assertArrayEquals(array, new int[]{3, 6, 7, 8, 10});
	}

	private void insertionSort(int[] array, int i) {// i = 1
		// if the list already ordered, the complexity become O(n)
		// Otherwise O(n2)
		if(array[i] < array[i - 1]) {
			int temp = array[i - 1];
			array[i - 1] = array[i];
			array[i] = temp;
			if(i-1 > 0){
				insertionSort(array, i-1); // n complexity
			}
		}
	}
}
