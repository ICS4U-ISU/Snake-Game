import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Apple extends Food {

	public Apple(int currentPoints) {
		super(currentPoints);
	}

//	public void spawnApple() {
//		randomX();
//		randomY();
//		if (x != snakeX && y != snakeY) {
//			// draw apple at x and y
//			// repaint screen
//		} else {
//			randomX();
//			randomY();
//			spawnApple();
//		}
//	}

	public static void appleEat() {
		try {
			appleSound = new AudioStream(new FileInputStream("C:/Users/ajayg/git/Snake-Game/Apple Sound.wav"));
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		AudioPlayer.player.start(appleSound);
		currentPoints = Board.getPoints();
		Board.setPoints(currentPoints + pointsApple);
		appleRandomizer();
	}

	public static void appleRandomizer() {
		int r = (int) (Math.random() * 10);
		Board.setAppleX(((r * 50)));

		r = (int) (Math.random() * 10);
		Board.setAppleY(((r * 50)));
		
	}
}
