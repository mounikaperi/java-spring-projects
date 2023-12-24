package com.springpractice.springcore;

import com.springpractice.springcore.games.GameRunner;
import com.springpractice.springcore.games.MarioGame;

public class AppGaming {
    public static void main(String args[]) {
        MarioGame marioGame = new MarioGame();
        GameRunner gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
