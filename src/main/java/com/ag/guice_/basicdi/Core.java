package com.ag.guice_.basicdi;

import com.google.inject.Guice;
import com.google.inject.Injector;

//The default scope creates a new instance every time you inject an object (or call get() on its Provider). Guice provides other scopes such as Singleton, Session, and Request

public class Core {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new EmptyModule());
		TestClass1 instance1 = injector.getInstance(TestClass1.class);

		TestClass1 instance2 = injector.getInstance(TestClass1.class);


		instance1.print();
		instance2.print();
	}
}
