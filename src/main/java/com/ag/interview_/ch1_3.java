package com.ag.interview_;

public class ch1_3 {

	//remove duplicate letters from String, don not use other array
	
	public String removeDuplicetes(String word) {
		
		if(word==null) {
			return null;
		}
		char[] array = word.toCharArray();
		
		for(int i = 0 ; i<array.length; i++) {
			char controlLetter = array[i];
			int letterCount = 0;
			for(int j = 0 ; j<array.length ; j++) {
				if(controlLetter == array[j]) {
					letterCount++;
				}
				if(letterCount > 1) {
					array[j]=' ';
					break;
				}
			}
		}
		return String.valueOf(array) ;
	}
	
	
}
