package com.ag.springboot.di_;

import org.springframework.stereotype.Component;

@Component
public class TestClass {
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
