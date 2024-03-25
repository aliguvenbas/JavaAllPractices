package com.ag.quicksort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class QuickSortExample {

	@Test
	public void shouldSortTheArray() {
		int[] array = {2, 5, 6, 7, 3, 1, 4};

		Arrays.stream(array).boxed().forEach(System.out::print);

		quickSort(array, 0, array.length - 1);

		System.out.println("--");
		Arrays.stream(array).boxed().forEach(System.out::print);

		assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7}, array );
	}

	private void quickSort(int[] array, int lowIndex, int highIndex) {

		if(lowIndex >= highIndex) {
			return;
		}

		// last element of the array is my pivot
		int pivot = array[highIndex];

		int leftPointer = lowIndex;
		int rightPointer = highIndex;

		while(leftPointer < rightPointer) {

			while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;// shift the pointer to the right
			}

			while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;// shift the pointer to the left
			}

			swap(array, leftPointer, rightPointer);
		}

		swap(array, leftPointer, highIndex);

		// numbers that lower than the pivot
		quickSort(array, lowIndex, leftPointer - 1);

		//  numbers that higher than the pivot
		quickSort(array, leftPointer + 1, highIndex);
	}

	private void swap(int[] array, int leftPointer, int rightPointer) {
		int temp = array[leftPointer];
		array[leftPointer] = array[rightPointer];
		array[rightPointer] = temp;
	}
}
