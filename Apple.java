import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

@SuppressWarnings("serial")
public class Apple extends Food {
	/**
	 * Variable that causes the sound to not play when the game is launched
	 */
	static boolean firstPlayed = false;

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
		appleRandomizer();
	}
/**
 * Method that gets a new X and Y value for the apple
 */
	public static void appleRandomizer() {
		int r = (int) (Math.random() * 10);
		int x = r * 50;
		while (x < 45.5 || x > 1180) {
			r = (int) (Math.random() * 10);
			x = r * 50;
		}
		Board.setAppleX(x);
		r = (int) (Math.random() * 10);
		int y = r * 50;
		while (y < 49 || y > 585) {
			r = (int) (Math.random() * 10);
			y = r * 50;
		}
		Board.setAppleY(y);

	}
}
