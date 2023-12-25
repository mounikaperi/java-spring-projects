package com.springpractice.springcore.games;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole{
    PacManGame game;
    @Override
    public void up() {
        System.out.println("PacManGame- Go Up");
    }
    @Override
    public void down() {
        System.out.println("PacManGame- Go Down");
    }
    @Override
    public void left() {
        System.out.println("PacManGame- Go Left");
    }
    @Override
    public void right() {
        System.out.println("PacManGame - Go Right");
    }
}
