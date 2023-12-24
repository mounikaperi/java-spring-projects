package com.springpractice.springcore.games;

public class GameRunner {
    MarioGame game;
    public GameRunner(MarioGame game) {
        this.game = game;
    }
    public void run() {
        System.out.println("Running game: " + game);
    }
}
