package com.ag.modelmapper_;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class GenericModelMapper {

	private ModelMapper modelMapper = new ModelMapper();

	<S, T> List<T> mapTo(List<S> source, Class<T> targetType) {
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

		return source.stream().map(s -> modelMapper.map(s, targetType)).collect(Collectors.toList());
	}
}
