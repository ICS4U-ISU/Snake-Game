import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

@SuppressWarnings("serial")
public class Rat extends Food {
	static boolean firstPlayed = false;

	public Rat() {
	}

	public static void ratEat() {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(Rat.class.getResource("Rat Sound.wav"));
			ratSound = AudioSystem.getClip();
			ratSound.open(audioIn);
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
		if (firstPlayed == true) {
			ratSound.start();
		} else {
			firstPlayed = true;
		}
		ratRandomizer();
	}

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
