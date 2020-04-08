package com.ag.collections_;

public class DummyLoopElement {
	Object object1;
	Object object2;
	Object object3;

	public DummyLoopElement(Object object1, Object object2) {
		super();
		this.object1 = object1;
		this.object2 = object2;
	}

	public DummyLoopElement(Object object1, Object object2, Object object3) {
		super();
		this.object1 = object1;
		this.object2 = object2;
		this.object3 = object3;
	}

	public Object getObject1() {
		return object1;
	}

	public void setObject1(Object object1) {
		this.object1 = object1;
	}

	public Object getObject2() {
		return object2;
	}

	public void setObject2(Object object2) {
		this.object2 = object2;
	}

	public Object getObject3() {
		return object3;
	}

	public void setObject3(Object object3) {
		this.object3 = object3;
	}

}
