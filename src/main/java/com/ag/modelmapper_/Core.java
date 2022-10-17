package com.ag.modelmapper_;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class Core {

	private final ModelMapper modelMapper = new ModelMapper();

	@BeforeEach
	public void setup(){
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
	}

	@Test
	public void convertModels(){
		List<User> users = Arrays.asList(new User("ali", "gelibolu", 32),
				new User("oznur", "amasya", 32));

		List<UserDto> userDtos = users.stream()
				.map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		userDtos.forEach(userDto -> System.out.println(userDto.getName()+"-"+userDto.getTown()+"-"+userDto.getAge()));

		assertEquals(2, userDtos.size());


	}

	@Test
	public void convertModelsWithGenericModelMapper(){

		GenericModelMapper genericModelMapper = new GenericModelMapper();

		List<User> users = Arrays.asList(new User("ali", "gelibolu", 32),
				new User("oznur", "amasya", 32));

		List<UserDto> userDtos = genericModelMapper.mapTo(users, UserDto.class);

		userDtos.forEach(userDto -> System.out.println(userDto.getName()+"-"+userDto.getTown()+"-"+userDto.getAge()));

		assertEquals(2, userDtos.size());


	}
}
