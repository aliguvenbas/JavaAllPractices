package com.ag.guice_.multiplebinds;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class Module1 extends AbstractModule {
	@Override
	protected void configure() {
		// Same binding in different modules gives error at run time
		// bind(ICar.class).to(Car1.class);
		Multibinder<ICar> carMultibinder = Multibinder.newSetBinder(binder(), ICar.class);
		carMultibinder.addBinding().to(Car1.class);
	}
}
