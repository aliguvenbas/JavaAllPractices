package com.ag.interview_;

public class ch1_5 {

	public String replaceSpaces(String str) {
		if(str==null) {
			return null;
		}
		char[] array = str.toCharArray();
		char[] newArray = new char[256];
		int newArrayIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				newArray[++newArrayIndex] = '%';
				newArray[++newArrayIndex] = '2';
				newArray[++newArrayIndex] = '0';
			} else {
				newArray[++newArrayIndex] = array[i];
			}
		}
		return String.valueOf(newArray).trim();
	}
}
