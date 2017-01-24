import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

@SuppressWarnings("serial")
public class Apple extends Food {
	static boolean firstPlayed = false;

	public Apple(int currentPoints) {
		super(currentPoints);
	}

	public static void appleEat() {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(Apple.class.getResource("Apple Sound.wav"));
			appleSound = AudioSystem.getClip();
			appleSound.open(audioIn);
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		if (firstPlayed == true) {
			appleSound.start();
		} else {
			firstPlayed = true;
		}
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
