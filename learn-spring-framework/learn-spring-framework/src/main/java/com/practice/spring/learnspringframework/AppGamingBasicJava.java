package com.practice.spring.learnspringframework;

import com.practice.spring.learnspringframework.game.GameRunner;
import com.practice.spring.learnspringframework.game.MarioGame;
import com.practice.spring.learnspringframework.game.PacManGame;
import com.practice.spring.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		// Object Creation
		var marioGame = new MarioGame(); 
		// Object Creation + Wiring of Dependencies-> marioGame is a dependency of GameRunner
		// Hence, we cannot have so many objects being created. We will have spring to handle these dependency
		var marioGameRunner = new GameRunner(marioGame); 
		marioGameRunner.run();
		
		var superContraGame = new SuperContraGame();
		var superContraGameRunner = new GameRunner(superContraGame);
		superContraGameRunner.run();
		
		var pacManGame = new PacManGame();
		var pacManGameRunner = new GameRunner(pacManGame);
		pacManGameRunner.run();
	}
}
