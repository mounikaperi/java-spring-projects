package com.springpractice.springcore.lazyIntialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}
@Component
@Lazy
class ClassB {
    private ClassA classA;
    public ClassB(ClassA classA) {
        System.out.println("Initialization of ClassB");
        this.classA = classA;
    }
    public void runClassB() {
        System.out.println("Bean of ClassB loaded lazily only when its methods are called");
    }
}
@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("Initialization of context is completed...");
            context.getBean(ClassB.class).runClassB();
        }
    }
}
