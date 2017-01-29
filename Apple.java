// Team SNAP
// Pranav G, Maryam S, Ajay G and Jennifer N.
// Snake Game
// This program is a reimagining of the classic game: "Snake"
// 25 January 2017
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

@SuppressWarnings("serial")
public class Apple extends Food {
	/**
	 * Variable that causes the sound to not play when the game is launched
	 */
	static boolean firstPlayed = false;

	/**
	 * Method for when the snake eats an apple
	 */
	public static void appleEat() {
		// Gets apple sound ready
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(Apple.class.getResource("Apple Sound.wav"));
			appleSound = AudioSystem.getClip();
			appleSound.open(audioIn);
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		if (firstPlayed == true) {
			appleSound.start(); // Plays apple sound
		} else {
			firstPlayed = true;
		}
		// sets the applce in its place after its been eaten
		int x = randomizerX();
		Board.setAppleX(x);
		int y = randomizerY();
		Board.setAppleY(y);
	}
}
