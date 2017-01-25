import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

@SuppressWarnings("serial")
public class Rat extends Food {
	/**
	 * Variable that causes the sound to not play when the game is launched
	 */
	static boolean firstPlayed = false;

	/**
	 * Method for when the snake eats a rat
	 */
	public static void ratEat() {
		// Gets the rat sound ready
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(Rat.class.getResource("Rat Sound.wav"));
			ratSound = AudioSystem.getClip();
			ratSound.open(audioIn);
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		if (firstPlayed == true) {
			ratSound.start(); // Plays rat sound
		} else {
			firstPlayed = true;
		}
		ratRandomizer();
	}

	/**
	 * Method that gets a new X and Y value for the rat
	 */
	public static void ratRandomizer() {
		int r = (int) (Math.random() * 10);
		int x = r * 50;
		while (x < 45.5 || x > 1180) {
			r = (int) (Math.random() * 10);
			x = r * 50;
		}
		Board.setRatX(x);
		r = (int) (Math.random() * 10);
		int y = r * 50;
		while (y < 49 || y > 585) {
			r = (int) (Math.random() * 10);
			y = r * 50;
		}
		Board.setRatY(y);

	}
}
