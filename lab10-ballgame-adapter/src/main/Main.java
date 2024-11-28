package main;

import game.BallGame;
import platforms.android.AndroidAdapter;
import platforms.playstation.PlayStationAdapter;
import platforms.windows.WindowsAdapter;

public class Main {
	
	public static void main(String[] args) {
		BallGame game = new BallGame(new PlayStationAdapter());
		game.play();

		BallGame game2 = new BallGame(new AndroidAdapter());
		game2.play();

		BallGame game3 = new BallGame(new WindowsAdapter());
		game3.play();
	}
}
