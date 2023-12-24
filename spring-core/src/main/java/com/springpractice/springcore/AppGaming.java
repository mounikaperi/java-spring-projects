package com.springpractice.springcore;

import com.springpractice.springcore.games.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        System.out.println(context.getBean("name"));
    }
}
