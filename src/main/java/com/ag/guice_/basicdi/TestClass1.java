package com.ag.guice_.basicdi;

import com.google.inject.Inject;

public class TestClass1 {
	String name;

	public void print() {
		System.out.println("test class:" + this.hashCode());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
