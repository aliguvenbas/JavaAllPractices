package com.ag.guice_;

import com.google.inject.Inject;
import org.slf4j.Logger;

public class Communication {
	@Inject
	private Logger logger;

	@Inject
	private Communicator communicator;

	public Communication(Boolean keepRecords) {
		if (keepRecords) {
			System.out.println("Message logging enabled");
		}
	}

	public boolean sendMessage(String message) {
		return communicator.sendMessage(message);
	}
}
