package com.ag.guice_.basicdi;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Core {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new EmptyModule());
		TestClass1 instance = injector.getInstance(TestClass1.class);

		instance.printMsg();

	}
}
