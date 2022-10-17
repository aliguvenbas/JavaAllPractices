package com.ag.springboot.di_;

import org.springframework.stereotype.Service;

@Service
public class Bike implements Vehicle{
	@Override
	public String getName() {
		return "bike";
	}
}
