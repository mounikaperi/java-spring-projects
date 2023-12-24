package com.springpractice.springcore;

import com.springpractice.springcore.games.GameRunner;
import com.springpractice.springcore.games.MarioGame;
import com.springpractice.springcore.games.PacManGame;
import com.springpractice.springcore.games.SuperContraGame;

public class AppGaming {
    public static void main(String[] args) {
        MarioGame marioGame = new MarioGame();
        GameRunner marioGameRunner = new GameRunner(marioGame);
        marioGameRunner.run();

        SuperContraGame superContraGame = new SuperContraGame();
        GameRunner superContraGameRunner = new GameRunner(superContraGame);
        superContraGameRunner.run();

        PacManGame pacManGame = new PacManGame();
        GameRunner pacManGameRunner = new GameRunner(pacManGame);
        pacManGameRunner.run();
    }
}
