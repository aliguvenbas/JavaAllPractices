package com.ag.reflection_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Core {
	public static void main(String[] args) {
		existingClass();
		compiledClass();
		getPrivateMethods();

		SampleCls sampleCls = new SampleCls();
		try {
			System.out.println(sampleCls.getMap());
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static void getPrivateMethods() {
		SampleCls sampleCls = new SampleCls();

		Class<? extends SampleCls> aClass = sampleCls.getClass();

		try {
			Field name = aClass.getDeclaredField("name");
			name.setAccessible(true);

			System.out.println("a private field name is "+name.getName());
		} catch(NoSuchFieldException e) {
			e.printStackTrace();
		}

		try {
			Method getAge = aClass.getDeclaredMethod("getAge");
			getAge.setAccessible(true);

			System.out.println("a private method name is "+getAge.getName());
		} catch(NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private static void compiledClass() {
		Class<Arrays> cls = Arrays.class;
		for(Method method : cls.getMethods()){
			System.out.println("Method:"+method.getName());
		};
		for(Field field : cls.getDeclaredFields()){
			System.out.println("Field:"+field.getName());
		}

		System.out.println("Modifiers:"+cls.getModifiers());

	}

	private static void existingClass() {
		try {
			Class<?> cls = Class.forName("com.ag.reflection_.SampleCls");
			Constructor<?> cons = cls.getDeclaredConstructor(String.class,Integer.TYPE);
			for(Method method : cls.getMethods()){
				System.out.println("Method:"+method.getName());
			};
			for(Field field : cls.getDeclaredFields()){
				System.out.println("Field:"+field.getName());
			}

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
