package com.ag.springboot.di_;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//Spring also provides multiple scopes — however, the default scope is Singleton. By default, Spring will create only one instance of each bean

@SpringBootApplication
public class Core {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Core.class, args);
		TestClass bean1 = context.getBean(TestClass.class);
		TestClass bean2 = context.getBean(TestClass.class);

		bean1.print();
		bean2.print();
	}
}
