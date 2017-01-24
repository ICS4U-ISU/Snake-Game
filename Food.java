import javax.sound.sampled.Clip;

import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Food extends NonMoving {

	static int pointsApple = 20;
	static int pointsRat = 100;
	static int currentPoints;
	
	static Clip appleSound;
	static Clip ratSound;
	

	public Food() {
	}
}
