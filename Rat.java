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
		int x = randomizerX();
		Board.setRatX(x);
		int y = randomizerY();
		Board.setRatY(y);
	}
}
