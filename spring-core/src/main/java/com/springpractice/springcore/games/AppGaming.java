package com.springpractice.springcore.games;

import com.springpractice.springcore.games.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppGaming {
    public static void main(String[] args) {
        // TightCoupling by creating objects specific to a class
        // LooseCoupling by creating an interface and classes implementing the interface
        // Allow Spring to create objects and wire the corresponding dependencies
        // Launch a Spring Context
        // Configure the things that we want Spring to manage - @Configuration

        /**
        MarioGame marioGame = new MarioGame();
        GameRunner marioGameRunner = new GameRunner(marioGame);
        marioGameRunner.run();

        SuperContraGame superContraGame = new SuperContraGame();
        GameRunner superContraGameRunner = new GameRunner(superContraGame);
        superContraGameRunner.run();

        PacManGame pacManGame = new PacManGame();
        GameRunner pacManGameRunner = new GameRunner(pacManGame);
        pacManGameRunner.run();
         */

        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);
        System.out.println("Bean name: " + context.getBean("name"));
        System.out.println("Bean age: " + context.getBean("age"));
        System.out.println("Bean myAddress " + context.getBean("myAddress"));
        System.out.println("Bean person " + context.getBean("person"));
        System.out.println("Bean person1 " + context.getBean("person1"));
        System.out.println("Bean person2 " + context.getBean("person2"));
        System.out.println("Bean Address class " + context.getBean(Address.class));
        System.out.println("Bean Person class " +context.getBean(Person.class));
        // List of all beans managed by spring
        System.out.println("All Bean Definitions ");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("Bean count " + context.getBeanDefinitionCount());
    }
}
