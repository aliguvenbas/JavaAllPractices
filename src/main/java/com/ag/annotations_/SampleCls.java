package com.ag.annotations_;

public class SampleCls {

	public final static int NO = 1;
	private String name;
	private int age;

	public SampleCls() {
		this("John", 30);
	}

	public SampleCls(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static void printNo() {
		System.out.println("No:" + NO);
	}

	@PrintMethodName(level = "info")
	@NameCheck
	public String getName() {
		return name;
	}

	@PrintMethodName(level = "error", format = false)
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@PrintMethodName
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + "," + age;
	}

	@PrintMethodName(level = "info")
	@NameCheck
	public void incrementAge() {
		++age;
	}
}
