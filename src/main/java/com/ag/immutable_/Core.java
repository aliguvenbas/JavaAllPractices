package com.ag.immutable_;

public class Core {
	public static void main(String[] args) {
		//##FinalClassProtectImmutability##
//		1-FinalClassWithStaticFields.values = Arrays.asList("blabla");//this is not correct, because 'values' is final

		//1-this breaks the immutability of 'static final'.We can add new values.
//		FinalClassWithStaticFields.values.add("first bla");
//		FinalClassWithStaticFields.values.forEach(System.out::println);

		//2, protect immutability is done
		FinalClassProtectImmutability.values.add("second bla");
		FinalClassProtectImmutability.values.forEach(System.out::println);


		//##ImmutableStaticFactory##
		//Only way of create new instance. We could use a normal constructor as well but this way preclude inheritance
		ImmutableStaticFactory immutableStaticFactory = ImmutableStaticFactory.valueOf(1.1, 2);
	}
}
