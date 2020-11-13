package com.ag.guice_;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Core {
	public static void main(String[] args) {
		//Module definitions
		// Module is the basic unit of definition of bindings, in spring wiring
		// Code first approach DI
		Injector injector = Guice.createInjector(new BasicModule());

		Communication communication = injector.getInstance(Communication.class);
	}
}
