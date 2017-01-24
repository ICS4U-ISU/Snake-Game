import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Rat extends Food {
	static boolean firstPlayed = false;

	public Rat(int currentPoints) {
		super(currentPoints);
	}

	public static void ratEat() {
		try {
			ratSound = new AudioStream(new FileInputStream("C:/Users/ajayg/git/Snake-Game/Rat Sound.wav"));
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		if (firstPlayed == true) {
			AudioPlayer.player.start(ratSound);
		} else {
			firstPlayed = true;
		}
		currentPoints = Board.getPoints();
		Board.setPoints(currentPoints + pointsRat);
		ratRandomizer();
	}

	public static void ratRandomizer() {
		int r = (int) (Math.random() * 10);
		Board.setRatX(((r * 50)));

		r = (int) (Math.random() * 10);
		Board.setRatY(((r * 50)));

	}
}
