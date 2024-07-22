package com.ag.assign_;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Core {

	@Test
	public void shouldAssignValueOfTheVariable() {
		int a = 3;
		int b;
		int c = a;
		int d = c;

		a = 4;

		System.out.println("a:" + a + "-c:" + c + "-d:" + d);

		assertEquals(4, a);
		assertEquals(3, c);
		assertEquals(3, d);
	}

	@Test
	public void shouldAssignValueOfTheVariable2() {
		Integer a = 3;
		Integer c = a;
		Integer d = c;

		a = 4;

		System.out.println("a:" + a.hashCode() + "-c:" + c.hashCode() + "-d:" + d.hashCode());

		assertEquals(4, a.intValue());
		assertEquals(3, c.intValue());
		assertEquals(3, d.intValue());
	}

	@Test
	public void shouldChangingValueNotAffectListItem() {
		int a = 3;
		int c = a;
		Integer d = c;

		ArrayList list = new ArrayList();
		list.add(a);
		list.add(c);
		list.add(d);

		a=4;

		list.forEach(System.out::println);

//		assertEquals(4, a.intValue());
//		assertEquals(3, c.intValue());
//		assertEquals(3, d.intValue());
	}

	@Test
	public void shouldHashCodeChangeAfterNewItemAddedToTheList() {
		int a = 5;
		int c = a;
		Integer d = c;

		List<Integer> list = new ArrayList<>();
		list.add(a);
		int hashCode = list.hashCode();
		list.add(c);
		int hashCode1 = list.hashCode();
		list.add(d);
		int hashCode2 = list.hashCode();

		System.out.println(hashCode1+"-"+hashCode2);

		assertNotSame(hashCode1,hashCode2);

//		/**
//		 * Returns the hash code value for this list.
//		 *
//		 * <p>This implementation uses exactly the code that is used to define the
//		 * list hash function in the documentation for the {@link List#hashCode}
//		 * method.
//		 *
//		 * @return the hash code value for this list
//		 */
//		public int hashCode() {
//			int hashCode = 1;
//			for (E e : this)
//				hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
//			return hashCode;
//		}
	}

	@Test
	public void shouldReturnDifferentHashCodesEvenIfSameStaticReturn(){
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd");

		assertNotSame(formatter1.hashCode(), formatter2.hashCode());
	}

	@Test
	public void shouldReturnSameHashCodesFromStaticContext(){
		assertNotSame(DateTimeFormatter.ofPattern("yyyyMMdd").hashCode(), DateTimeFormatter.ofPattern("yyyyMMdd").hashCode());
	}
}
