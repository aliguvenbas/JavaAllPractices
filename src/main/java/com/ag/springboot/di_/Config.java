package com.ag.springboot.di_;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

	@Bean
	@Scope("singleton")
	public TestClass singTestClass(){
		return new TestClass();
	}

//	@Bean
//	@Scope("prototype")
//	public TestClass proTestClass(){
//		return new TestClass();
//	}
}
