import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

@SuppressWarnings("serial")
public class Apple extends Food {
	static boolean firstPlayed = false;
	static int i = 0;

	public Apple() {
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
		appleRandomizer();
	}

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
