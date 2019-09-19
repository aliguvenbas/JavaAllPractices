package com.ag.interview_;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ch1_6Test {

	ch1_6 test = new ch1_6();
	@Test
	void test() {
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix90 = new int[][] {{7,4,1},{8,5,2,},{9,6,3}};
		
		assertArrayEquals(matrix90, test.reverse90(matrix));
	}
	
	@Test
	void test2() {
		int[][] matrix = new int[][] {{1,2,3,0},{4,5,6,0},{7,8,9,0}};		
		assertNull(test.reverse90(matrix));
	}

	@Test
	void test3() {
		assertNull(test.reverse90(null));
	}
}
