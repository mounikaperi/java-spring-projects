package com.springpractice.springcore.games;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Component will inform spring that this particular class is eligible for component scan and creating new objects by spring container
@Component
@Primary
public class MarioGame implements GamingConsole{
    MarioGame game;
    public void up() {
        System.out.println("Jump");
    }
    public void down() {
        System.out.println("Go into a hole");
    }
    public void left() {
        System.out.println("Go back");
    }
    public void right() {
        System.out.println("Accelerate");
    }
}
