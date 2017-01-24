import java.io.FileInputStream;
import java.util.Random;

import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Food extends NonMoving {

	static int pointsApple = 20;
	static int pointsRat = 100;
	boolean rat;
	static AudioStream appleSound;
	static AudioStream ratSound;
	static int currentPoints;

	public Food(int currentPoints) {
		super(currentPoints);
		try {
			AudioStream ratSound;
			ratSound = new AudioStream(new FileInputStream("C:/Users/ajayg/git/Snake-Game/Rat Sound.wav"));
			Food.ratSound = ratSound;
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public void randomRat() {
		Random rand = new Random();
		int random = rand.nextInt(10);
		if (random > 2) {
			rat = false;
		} else {
			rat = true;
		}
	}

	public boolean getRat() {
		return rat;
	}
}
