package com.ag.immutable_;

public class ImmutableStaticFactory {
	private double first;
	private double second;

	private ImmutableStaticFactory(double first, double second) {
		this.first = first;
		this.second = second;
	}

	public static ImmutableStaticFactory valueOf(double first, double second) {
		return new ImmutableStaticFactory(first, second);
	}
}

//Not allowed, because ImmutableStaticFactory has no default constructor
//public class ImmutableStaticFactorySubClass extends ImmutableStaticFactory{
//
//}

