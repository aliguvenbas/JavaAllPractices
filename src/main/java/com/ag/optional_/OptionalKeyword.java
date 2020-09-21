package com.ag.optional_;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OptionalKeyword {


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
		Optional.ofNullable("aliveli").ifPresent(name -> {
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

	@Test
	public void shouldMapNotCallIfValueIsNull() {
		StringAppender stringAppender = spy(new StringAppender());
		String name = null;
		Optional<String> nameOpt =  Optional.ofNullable(name).map(stringAppender::getAppended);

		assertFalse(nameOpt.isPresent());

		verify(stringAppender, never()).getAppended(any());
	}

}

class StringAppender{
	String getAppended(String text){
		return text + "!!! ";
	}
}
