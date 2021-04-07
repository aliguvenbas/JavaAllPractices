package com.ag.guice_.multiplebinds;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import java.util.Set;

public class Core {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new Module1(), new Module2());

		Set<ICar> instance1 = injector.getInstance(Key.get(new TypeLiteral<Set<ICar>>() {
		}));

		instance1.forEach(car -> System.out.println("speed:" + car.getSpeed()));

	}
}
