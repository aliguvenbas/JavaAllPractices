package com.ag.serialization;

import java.io.Serializable;

public class SerializeCls implements Serializable {
	public int count;
	public String text;
	public int x;
	private boolean primitiveBoolean;
	private Boolean objectBoolean;

	public SerializeCls(int count, String text, int x, boolean primitiveBoolean, Boolean objectBoolean) {
		this.count = count;
		this.text = text;
		this.x = x;
		this.primitiveBoolean = primitiveBoolean;
		this.objectBoolean = objectBoolean;
	}
}
