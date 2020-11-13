package com.ag.guice_;

import com.google.inject.AbstractModule;

public class BasicModule extends AbstractModule {
	@Override
	protected void configure() {
		//an instance of DefaultCommunicatorImpl is to be injected wherever a Communicator variable is found
		bind(Communicator.class).to(DefaultCommunicatorImpl.class);

		bind(Boolean.class).toInstance(true);
		try {
			bind(Communication.class).toConstructor(Communication.class.getConstructor(Boolean.TYPE));
		} catch(NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
