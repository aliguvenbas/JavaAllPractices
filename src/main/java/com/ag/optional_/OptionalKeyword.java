package com.ag.optional_;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OptionalKeyword {

//	### Prefer value-based alternatives to generic ones
//	There are special non-generic Optional classes. OptionalInt, OptionalLong, and OptionalDouble.

//	## Don’t make Optional from collections. use emptyList() insteadOf Optional<List<Student>>
//	Any collections is a container itself which emptiness can be determined without additional classes. Empty list — a better approach

//	##Don’t pass Optional as a parameter
//			public void doAction() {
//				OptionalInt age = getAge();
//				Optional<Role> role = getRole();
//				applySettings(name, age, role);
//			}
//	we have no idea how does the method interprets an Optional. Does it just replace the absent value with the default one or does it completely
// 	change the business logic? Or maybe it just throws NoSuchElementException.


	@Test
	public void shouldBeFalseWhenEmptyOptional() {
		Optional<Integer> optNr = Optional.empty();
		assertFalse(optNr.isPresent());
	}

	@Test
	public void shouldPresentTrueWhenOptionalOfSth() {
		Optional<String> opt = Optional.of("Test");
		assertTrue(opt.isPresent());
	}

	@Test
	public void shouldThrowExceptionWhenOptionalIsNull() {
		//of() can not be null
		String name = null;
		assertThrows(NullPointerException.class, () -> Optional.of(name));
	}

	@Test
	public void shouldNotThrowExceptionWhenOptionalIsNullable() {
		//ofNullable() can be null, not throws NullPointerException but isPresent() = false
		String name = null;
		assertFalse(Optional.ofNullable(name).isPresent());
	}

	@Test
	public void shouldReplaceString() {
		Optional.ofNullable("aliveli")
				.ifPresent(name -> {
							name = name.replaceAll("l", "");
							assertEquals("aivei", name);
						}
				);
	}

	@Test
	public void shouldBeDefaultValueWhenInputIsNull() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("John");
		assertEquals("John", name);
	}

	@Test
	public void shouldGiveValueEvenIfDefaultValueExist() {
		String nullName = "aliveli";
		String name = Optional.ofNullable(nullName).orElse("John");
		assertEquals("aliveli", name);
	}

	//Using map() with optional keyword -----------------------------------------
	@Test
	public void shouldMapNotCallIfValueIsNull() {
		StringAppender stringAppender = spy(new StringAppender());
		String name = null;
		Optional<String> nameOpt = Optional.ofNullable(name).map(stringAppender::getAppended);

		assertFalse(nameOpt.isPresent());

		verify(stringAppender, never()).getAppended(any());
	}

	@Test
	public void shouldCallOrElseGetIfValueIsNull() {
		StringAppender stringAppender = spy(new StringAppender());
		String name = null;
		String result = Optional.ofNullable(name)
				.map(stringAppender::getAppended)
				.orElseGet(() -> {
					System.out.println("OrElseGet");
					System.out.println("called");
					return "--";
				});

		assertEquals("--", result);

		verify(stringAppender, never()).getAppended(any());
	}

	@Test(expected = IllegalStateException.class)
	public void shouldCallOrElseThrowIfValueIsNull() {
		StringAppender stringAppender = spy(new StringAppender());
		String name = null;
		String result = Optional.ofNullable(name)
				.map(stringAppender::getAppended)
				.orElseThrow(() -> {
					System.out.println("OrElseGet");
					System.out.println("called");
					return new IllegalStateException("exception thrown");
				});

		fail();

		verify(stringAppender, never()).getAppended(any());
	}
	//----------------------------------------------------------------------------------

	// orElse VS  orElseGet -----------------------------------------
	@Test
	public void shouldCallOrElseMethodEveryTimeEvenIfObjectNotNull() {
		String text = "ted mosby";
		String who = Optional.ofNullable(text)
				.orElse(getHisBestMan());
	}

	@Test
	public void shouldNotCallOrElseMethodEveryTimeIfObjectNotNull() {
		String text = "ted mosby";
		String who = Optional.ofNullable(text)
				.orElseGet(() -> getHisBestMan());
	}

	private String getHisBestMan() {
		System.out.println("call best man");
		return "Marshall Eriksen";
	}
	//----------------------------------------------------------------------------------

	@Test
	public void test(){
		Set<String> memberEmails = new HashSet<>();

		List<String> collect = memberEmails.stream().map(email -> email + "!!")
				.collect(Collectors.toList());

		assertNotNull(collect);
		assertTrue(collect.isEmpty());
	}

}

class StringAppender {
	String getAppended(String text) {
		return text + "!!! ";
	}
}
