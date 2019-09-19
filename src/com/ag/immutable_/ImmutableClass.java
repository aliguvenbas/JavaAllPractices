package com.ag.immutable_;

//any object of this class can not be changed after initialize
//String is immutable
public class ImmutableClass {

		private String name;
		private int id;
		
		ImmutableClass(String name, int id){
			this.name  = name;
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		public int getId() {
			return id;
		}
}
