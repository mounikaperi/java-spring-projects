package com.practice.spring.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// record is a new feature introduced in JDK 16. 
// Instead of creating several fields, constructors, getters, setters and toString. 
// record eliminated verbosity and automatically created all of them.
record Person (String name, int age) {
	
}

@Configuration
public class HelloWorldConfiguration {
	
	@Bean 
	public String name() {
		return "sampleName";
	}
	
	@Bean
	public int age() {
		return 15;
	}
}
