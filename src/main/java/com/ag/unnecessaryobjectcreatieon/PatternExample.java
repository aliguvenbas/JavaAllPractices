package com.ag.unnecessaryobjectcreatieon;

import static junit.framework.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class PatternExample {

	@Test
	public void shouldAvoidCreateMoreObjectsWhenUsingMatcher() {

		List<String> stringList = getList();

		long t1 = System.currentTimeMillis();
		stringList.stream().forEach(str -> str.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"));
		long t2 = System.currentTimeMillis();

		long calc1 = t2 - t1;
		System.out.println("calc1:" + calc1);

		t1 = System.currentTimeMillis();
		Pattern pattern = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$", 0);
		stringList.stream().forEach(str -> pattern.matcher(str).matches());
		t2 = System.currentTimeMillis();

		long calc2 = t2 - t1;
		System.out.println("calc2:" + calc2);

		assertTrue(calc2 < calc1);

	}

	private List<String> getList() {
		List<String> stringList = new ArrayList<>();

		for(int i = 0; i < 100; i++) {
			byte[] array = new byte[7]; // length is bounded by 7
			new Random().nextBytes(array);
			String generatedString = new String(array, Charset.forName("UTF-8"));
			stringList.add(generatedString);
			System.out.println("** " + generatedString);
		}

		return stringList;
	}
}
