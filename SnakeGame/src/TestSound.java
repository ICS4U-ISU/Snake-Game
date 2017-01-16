import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class TestSound {
	

	public static void main(String[] args) {
		playSound();
	}
	public static void playSound() {
		String testAudio = "H:/git/Snake-Game/SnakeGame/src/cartoon001.wav";
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(testAudio).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}