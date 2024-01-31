package com.springcore.config;

import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"com.springcore.implementation", "com.springcore.services"})
@ComponentScan(basePackageClasses = {com.springcore.beans.Person.class, com.springcore.beans.Vehicle.class})
public class Configuration {

}
