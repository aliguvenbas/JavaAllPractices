package com.ag.optional_;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionalKeyword {


	@Test
	public void shouldBeFalseWhenEmptyOptional(){
		Optional<Integer> optNr  = Optional.empty();
		assertFalse(optNr.isPresent());
	}

	@Test
	public void shouldPresentTrueWhenOptionalOfSth(){
		Optional<String> opt  = Optional.of("Test");
		assertTrue(opt.isPresent());
	}

	@Test
	public  void shouldThrowExceptionWhenOptionalIsNull(){
	//of() can not be null
		String name  = null;
		assertThrows(NullPointerException.class , ()->Optional.of(name));
	}

	@Test
	public void shouldNotThrowExceptionWhenOptionalIsNullable(){
		//ofNullable() can be null, not throws NullPointerException but isPresent() = false
		String name = null;
		assertFalse(Optional.ofNullable(name).isPresent());
	}

	@Test
	public void shouldReplaceString(){
		Optional.ofNullable("aliveli").ifPresent(name-> {
			name = name.replaceAll("l","");
					assertEquals("aivei",name );
				}
		);
	}

	@Test
	public void shouldBeDefaultValueWhenInputIsNull(){
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("John");
		assertEquals("John", name);
	}

	@Test
	public void shouldGiveValueEvenIfDefaultValueExist(){
		String nullName = "aliveli";
		String name = Optional.ofNullable(nullName).orElse("John");
		assertEquals("aliveli", name);
	}

	@Test
	public void shouldGiveValueEvenIfDefaultValueExist2(){
		List list = Arrays.asList(null,null,null,null);
		Optional<String> name = list.stream().filter(Objects::nonNull).max(Comparator.naturalOrder());
		System.out.println(name.get());
		assertEquals("Test", name.get());
	}
}
