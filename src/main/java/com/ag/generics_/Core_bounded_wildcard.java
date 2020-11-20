package com.ag.generics_;

import org.junit.jupiter.api.Test;

public class Core_bounded_wildcard {

	@Test
	public void useBoundedWildcard(){

	}
}


class Stack<E>{
	public Stack(){

	};
	public void push(E e){

	};
	public E pop(){
		return null;
	};
	public boolean isEmpty(){
		return false;
	};
}
