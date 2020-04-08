package com.ag.string_;

public class Strign_Buffer_Builder {

	public static void main(String[] args) {
		String str1 = "ali";		
		String str2 = "veli";
		String str3 = str1 + str2;
		System.out.println(str1.hashCode()+" - "+str2.hashCode()+" - "+str3.hashCode());
		
		str1 = str1 + " güvenbaş";
		System.out.println(str1.hashCode()+" - "+str2.hashCode()+" - "+str3.hashCode());
		
		System.out.println("***********************************************************");
		
		StringBuffer strB1= new StringBuffer("ali");
		StringBuffer strB2 =new StringBuffer("veli");
		StringBuffer strB3 = strB1.append(strB2);
		System.out.println(strB1.hashCode()+" - "+strB2.hashCode()+" - "+ strB3.hashCode());
		
		strB1.append(strB2);
		System.out.println(strB1+" | "+strB1.hashCode()+" - "+strB2.hashCode()+" - "+ strB3.hashCode());

	}

}
