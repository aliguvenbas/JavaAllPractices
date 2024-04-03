package com.ag.modelmapper_;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDto {
	private String name;
	private String town;
	private int age;
}
