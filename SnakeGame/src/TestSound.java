import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class TestSound {
	

	public static void main(String[] args) {
		String testAudio = "C:/Users/ajayg/git/Snake-Game/SnakeGame/src/cartoon001.wav";
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(testAudio).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        System.out.println("Sound played");
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}