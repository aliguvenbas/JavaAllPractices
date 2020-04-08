package com.ag.interview_;

public class ch1_6 {

	public int[][] reverse90(int[][] matrix) {
		if (matrix == null || (matrix.length != matrix[0].length) ) {
			return null;
		}
		int[][] matrix90 = new int[matrix.length][matrix.length];
		int indexMod = matrix.length -1 ;
		for (int i1 = 0; i1 < matrix.length; i1++) {
			for (int i2 = 0; i2 < matrix[0].length; i2++) {
				matrix90[i2][indexMod - i1] = matrix[i1][i2];
			}
		}

		return matrix90;
	}
}
