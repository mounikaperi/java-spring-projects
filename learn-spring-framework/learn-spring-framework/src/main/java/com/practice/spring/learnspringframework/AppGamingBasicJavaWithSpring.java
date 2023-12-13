package com.practice.spring.learnspringframework;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppGamingBasicJavaWithSpring {

	public static void main(String[] args) {
		try (
			// Step-1: Launch a Spring Context
			// Step-2: Configure the things that we want Spring framework to manage- @Configuration
			// name, age- @Bean
			// Step-3: Retrieving Beans managed by Spring
			var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
