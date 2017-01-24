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
		Board.setRatX(((r * 50)));

		r = (int) (Math.random() * 10);
		Board.setRatY(((r * 50)));
	}
}
