package com.ag.generics_;

import lombok.Builder;

public class Snake {
	int maxLength;

	@Builder
	public Snake(int maxLength) {
		this.maxLength = maxLength;
	}
}
