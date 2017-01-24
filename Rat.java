import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Rat extends Food {
	// Image of rat
	// Audio of rat

	public Rat(int currentPoints) {
		super(currentPoints);
	}

//	public void spawnRat() {
//		randomX();
//		randomY();
//		if (x != snakeX && y != snakeY) {
//			// draw rat at x and y
//			// repaint screen
//		} else {
//			randomX();
//			randomY();
//			spawnRat();
//		}
//	}

	public static void ratEat() {
		try {
			ratSound = new AudioStream(new FileInputStream("C:/Users/ajayg/git/Snake-Game/Rat Sound.wav"));
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		AudioPlayer.player.start(ratSound);
		currentPoints = Board.getPoints();
		Board.setPoints(currentPoints + pointsRat);
		appleRandomizer();
	}

	public static void appleRandomizer() {
		int r = (int) (Math.random() * 10);
		Board.setAppleX(((r * 50)));

		r = (int) (Math.random() * 10);
		Board.setAppleY(((r * 50)));
		
	}
}
