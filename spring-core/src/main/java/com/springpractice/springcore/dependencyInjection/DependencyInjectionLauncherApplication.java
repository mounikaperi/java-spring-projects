package com.springpractice.springcore.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BusinessClassWithFieldInjection {
    @Autowired
    Dependency1 dependency1;
    @Autowired
    Dependency2 dependency2;
    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class BusinessClassWithSetterInjection {
    Dependency1 dependency1;
    Dependency2 dependency2;
    public Dependency1 getDependency1() {
        return dependency1;
    }
    public Dependency2 getDependency2() {
        return dependency2;
    }
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }
    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class BusinessClassWithConstructorInjection {
    Dependency1 dependency1;
    Dependency2 dependency2;
    // No need to add @Autowired for constructor injection
    public BusinessClassWithConstructorInjection(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }
    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}
@Component
class Dependency1 {

}

@Component
class Dependency2 {

}
@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessClassWithFieldInjection.class));
            System.out.println(context.getBean(BusinessClassWithSetterInjection.class));
            System.out.println(context.getBean(BusinessClassWithConstructorInjection.class));
        }
    }
}
