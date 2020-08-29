package com.ag.annotations_;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface Anno1 {
	String name();
	boolean format();
}
