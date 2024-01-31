package com.springcore.casestudy1;

import com.springcore.beans.Person;
import com.springcore.beans.Vehicle;
import com.springcore.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Casestudy1Application {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(Configuration.class);
		String[] persons = context.getBeanNamesForType(Person.class);
		System.out.println(Arrays.stream(persons));

		Person person = context.getBean(Person.class);
		System.out.println(person);

		String[] vehicles = context.getBeanNamesForType(Vehicle.class);
		System.out.println(Arrays.stream(vehicles));

		Vehicle vehicle = context.getBean(Vehicle.class);
		vehicle.getVehicleService().moveVehicle();
		person.getVehicle().getVehicleService().moveVehicle();
		person.getVehicle().getVehicleService().playMusic();
	}

}
