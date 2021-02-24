package com.ag.annotations_;

import java.lang.reflect.Method;

public class NameCheckImplementer {
	public void implement(Object o) throws Exception {
		Class<?> aClass = o.getClass();

		for(Method method : aClass.getMethods()) {
			if(method.isAnnotationPresent(NameCheck.class)) {
				String methodName = method.getName();
				System.out.println("NameCheckImplementer ... " + methodName);
				if(!(methodName.contains("get") || methodName.contains("set"))) {
					System.out.println("name check error");
					throw new Exception();
				}
			}
		}

	}
}
