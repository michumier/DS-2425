package main;

import game.BallGame;
import platforms.android.AndroidGame;
import platforms.playstation.PlayStationGame;
import platforms.windows.WindowsGame;

public class Main {
	
	public static void main(String[] args) {
		BallGame game = new PlayStationGame();
		game.play();

		BallGame game2 = new AndroidGame();
		game2.play();

		BallGame game3 = new WindowsGame();
		game3.play();
	}
}
