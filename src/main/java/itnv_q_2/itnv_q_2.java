package itnv_q_2;

public class itnv_q_2 {

	public static void main(String[] args) {
		itnv_q_2 q_2 = new itnv_q_2();
		//q_2.solution("cccttnaaadhsylll");
		System.out.println(((int)'a'+6));
		System.out.println((char)((int)'a'+6));
		System.out.println((int)'y'-(int)'a');
		System.out.println((char)((int)'y'-(int)'a'));
		System.out.println('y'-'a');
		System.out.println((char)((int)'a'+('y'-'a')));
	}
	
	   String solution(String S) {
	        int[] occurrences = new int[26];
	        for (char ch : S.toCharArray()) {
	        	occurrences[ch - 'a']++;
	        }

	        char best_char = 'a';
	        int  best_res  = 0;
	        for (int i = 25; i >= 0; i--) {
	        	System.out.println(i + "***" + best_res+"**"+(char)((int)'a' + i));
	            if (occurrences[i] >= best_res ) {
	                best_char = (char)((int)'a' + i);
	                best_res  = occurrences[i];
	            }
	        }

	        System.out.println(Character.toString(best_char)+"!!!!!--"+best_res);
	        return Character.toString(best_char);
	    }

}


//int[] alphabet = new int[26];
//char[] textArray = text.toCharArray();
//
//for(int i = 0;i<textArray.length; i++ ){
//   
//            alphabet[textArray[i]-'a']++;
//
//}
//
//    
//     int letterCount= 0;
//     int alphabetIndex = 0;
//     
//     for(int j = 25 ;j>=0;j--){ 
//         System.out.println(alphabet[j]  + "**"+ (char) ((int) 'a' + j));
//        if(alphabet[j]>= letterCount){
//            alphabetIndex = j;
//            letterCount =alphabet[j]; 
//        }
//     }
//
//return (char)((int)'a'+ alphabetIndex);
