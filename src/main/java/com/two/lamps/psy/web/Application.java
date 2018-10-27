package com.two.lamps.psy.web;

import com.two.lamps.psy.web.config.TestDataInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean(initMethod = "init")
	public TestDataInitializer initTestData() {
		return new TestDataInitializer();
	}

}
