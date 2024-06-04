package com.ag.collections_.set_;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

public class SetTryOuts {

	@Test
	public void shouldAddOnlyOneStringIfThereAreMultipleStringsWithSameValue() {
		var str1 = "test";
		var str2 = "test";

		Set<String> dummyObjSet = new HashSet<>();
		dummyObjSet.add(str1);
		dummyObjSet.add(str2);

		assertEquals(1, dummyObjSet.size());
	}

	@Test
	public void shouldAddObjectsEvenIfTheContentIsSame() {
		DummyObj obj1 = new DummyObj(1, "test1");
		DummyObj obj2 = new DummyObj(1, "test1");

		Set<DummyObj> dummyObjSet = new HashSet<>();
		dummyObjSet.add(obj1);
		dummyObjSet.add(obj2);

		assertEquals(2, dummyObjSet.size());
	}

	@Test
	public void shouldNotAddAllObjectsIfHashCodeAndEqualsAreDifferent() {
		//HashCodes same and objects are equal
		DummyObj2 obj1 = new DummyObj2(1, "test1");
		DummyObj2 obj2 = new DummyObj2(1, "test1");

		Set<DummyObj2> dummyObjSet = new HashSet<>();
		dummyObjSet.add(obj1);
		dummyObjSet.add(obj2);

		assertEquals(1, dummyObjSet.size());
	}

	@Test
	public void shouldNotAddAllObjectsIfComparatorIsDifferentForTheObjects() {
		DummyObjComp obj1 = new DummyObjComp(1, "test1");
		DummyObjComp obj2 = new DummyObjComp(1, "test2");

		Set<DummyObjComp> dummyObjSet = new TreeSet<>();
		dummyObjSet.add(obj1);
		dummyObjSet.add(obj2);

		assertEquals(1, dummyObjSet.size());
	}

	@Test
	public void shouldAddObjectsIfWeUseTreeSetEvenIfTHashCodesAndObjectsAreEqualsButComparatorIsDifferent() {
		DummyObjComp obj1 = new DummyObjComp(1, "test1");
		DummyObjComp obj2 = new DummyObjComp(2, "test1");

		Set<DummyObjComp> dummyObjSet = new TreeSet<>();
		dummyObjSet.add(obj1);
		dummyObjSet.add(obj2);

		assertEquals(2, dummyObjSet.size());
	}

	@Test
	public void shouldThrowErrorIfObjectIsNotComparableOrCompareMethodIsNotDefinedInTreeSet() {
		DummyObj obj1 = new DummyObj(1, "test1");

		Set<DummyObj> dummyObjSet = new TreeSet<>();

		dummyObjSet.add(obj1);

		assertThrows(ClassCastException.class, () -> dummyObjSet.add(obj1));
	}

	@Test
	public void shouldNotThrowErrorIfObjectIsNotComparableButCompareMethodIsDefinedInTreeSet() {
		DummyObj obj1 = new DummyObj(1, "test1");

		Set<DummyObj> dummyObjSet = new TreeSet<>(Comparator.comparing(DummyObj::getX));

		dummyObjSet.add(obj1);

		assertTrue(dummyObjSet.size() == 1);
	}

	@Test
	public void shouldAddObjectsEventIfHashCodeIsSameButEqualsMethodComparisonIsDependsOnOtherProperty() {
		DummyObj2 obj1 = new DummyObj2(1, "test1");
		DummyObj2 obj2 = new DummyObj2(2, "test2");

		Set<DummyObj2> dummyObjSet = new HashSet<>();
		dummyObjSet.add(obj1);
		dummyObjSet.add(obj2);

		dummyObjSet.stream().forEach(dummyObj -> System.out.println(dummyObj.hashCode()));
		assertEquals(2, dummyObjSet.size());
	}
}

class DummyObj {
	private final int x;
	private final String y;

	public DummyObj(int x, String y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
}

class DummyObjComp implements Comparable<DummyObjComp> {
	private final int x;
	private final String y;

	public DummyObjComp(int x, String y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(DummyObjComp o) {
		return Integer.compare(this.x, o.x);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		DummyObjComp that = (DummyObjComp) o;
		return x == that.x && Objects.equals(y, that.y);
	}

	@Override
	public int hashCode() {
		return 1;
	}
}

class DummyObj2 {
	private final int x;
	private final String y;

	public DummyObj2(int x, String y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public String getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		DummyObj2 dummyObj2 = (DummyObj2) o;
		System.out.println(y + "-" + dummyObj2.y + "-" + (y.equals(dummyObj2.y)));
		return y.equals(dummyObj2.y);
	}

	@Override
	public int hashCode() {
		return x;
	}
}
