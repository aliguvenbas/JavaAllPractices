package com.ag.object_;

import static junit.framework.Assert.assertTrue;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

public class Compare {

	@Test
	public void shouldObjectsBeEqualIfUseEqualsAndHashCode() {
		CompareObject obj1 = new CompareObject("test1", "1");
		CompareObject obj2 = new CompareObject("test1", "1");

		CompareObject2 obj1Ne = new CompareObject2("test1", "1");
		CompareObject2 obj2Ne = new CompareObject2("test1", "1");

		assertTrue(Objects.equals(obj1, obj2));
		assertTrue(!Objects.equals(obj1Ne, obj2Ne));
	}
}

@AllArgsConstructor
@EqualsAndHashCode
class CompareObject {
	String var1;
	String var2;
}

@AllArgsConstructor
class CompareObject2 {
	String var1;
	String var2;
}
