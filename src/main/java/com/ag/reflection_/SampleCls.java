package com.ag.reflection_;

import com.google.common.collect.ImmutableMap;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + "," + age;
	}

	private void incrementAge() {
		++age;
	}

	public Map<String, Object> getMap() throws IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		for(Field field:this.getClass().getDeclaredFields()){
			map.put(field.getName(),field.get(this));
		}
		return map;
	}
}
