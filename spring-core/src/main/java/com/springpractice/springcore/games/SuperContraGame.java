package com.springpractice.springcore.games;

public class SuperContraGame implements GamingConsole{
   SuperContraGame game;
    @Override
    public void up() {
        System.out.println("SuperConta- Go Up");
    }
    @Override
    public void down() {
        System.out.println("SuperContra- Go Down");
    }
    @Override
    public void left() {
        System.out.println("SuperContra- Go Left");
    }
    @Override
    public void right() {
        System.out.println("SuperContra - Go Right");
    }
}
