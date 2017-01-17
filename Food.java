import java.io.FileInputStream;
import java.util.Random;

import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Food extends NonMoving {

	int pointsRat = 100;
	int pointsApple = 20;
	boolean rat;
	AudioStream appleSound;
	AudioStream ratSound;
	int snakeX;
	int snakeY;
	int currentPoints;

	public Food(int snakeX, int snakeY, int currentPoints) {
		super(snakeX, snakeY, currentPoints);
		try {
			AudioStream appleSound;
			appleSound = new AudioStream(new FileInputStream("H:/git/Snake-Game/SnakeGame/src/cartoon001.wav"));
			this.appleSound = appleSound;
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		try {
			AudioStream ratSound;
			ratSound = new AudioStream(new FileInputStream("H:/git/Snake-Game/SnakeGame/src/cartoon001.wav"));
			this.ratSound = ratSound;
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
