package com.ag.interview_;

public class ch1_8 {

	public boolean isSubString(String str1, String str2) {
		boolean ret = true;
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();

		if (array1.length != array2.length) {
			return false;
		}

		for (char ch2 : array2) {
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] == '*') {
					continue;
				}
				System.out.println(array1[i] + "-" + ch2);
				if (array1[i] == ch2) {
					array1[i] = '*';
				}
			}
		}

		System.out.println(String.valueOf(array1));
		for (char ch : array1) {
			if (ch != '*') {
				ret = false;
				break;
			}
		}

		return ret;
	}

}
