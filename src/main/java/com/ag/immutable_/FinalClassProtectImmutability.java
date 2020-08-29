package com.ag.immutable_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FinalClassProtectImmutability {
	//1-define as public is not correct.Yes, we couldn't renew the object but we can add new values.
	// Immutability is gone and security hole
//	public static final List<String> values = new ArrayList(Arrays.asList("one","two","three"));

	//2, this is a good solution for preclude modification of list, even if public
	public static final List<String> values = Collections.unmodifiableList(new ArrayList(Arrays.asList("one","two","three")));



}
