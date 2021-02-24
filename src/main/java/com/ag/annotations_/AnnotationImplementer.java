package com.ag.annotations_;

import java.lang.reflect.Method;

public class AnnotationImplementer {

	public void implement(Object o) {
		Class<?> aClass = o.getClass();

		for(Method method : aClass.getMethods()) {
			if(method.isAnnotationPresent(PrintMethodName.class)) {//check, is annotation exist
				PrintMethodName annotationValue = method.getAnnotation(PrintMethodName.class);// get annotation value
				boolean format = annotationValue.format();
				StringBuffer text = format ? new StringBuffer("formatted ") : new StringBuffer("");
				text.append(" priority level is " + annotationValue.level() + " of " + method.getName());
				System.out.println(text.toString());
			}
		}
	}
}
