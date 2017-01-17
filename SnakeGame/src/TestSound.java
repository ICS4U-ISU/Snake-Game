import java.io.FileInputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class TestSound {
	

	public static void main(String[] args) {
		String testAudio = "H:/git/Snake-Game/SnakeGame/src/cartoon001.wav";
	    try {
	    	AudioStream sound1;
			sound1 = new AudioStream(new FileInputStream(testAudio));
			AudioPlayer.player.start(sound1);
	        System.out.println("Sound played");
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}