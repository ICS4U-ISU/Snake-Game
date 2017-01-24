import java.io.FileInputStream;

import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Walls extends NonMoving {
	String wall = "image of wall";
	AudioStream hitSound;

	public Walls(int snakeX, int snakeY, int currentPoints) {
		super(currentPoints);
	}
	
	public void hitWall() {
		try {
			AudioStream hitSound;
			hitSound = new AudioStream(new FileInputStream("Hit Sound.wav"));
			this.hitSound = hitSound;
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

//	public void spawnWall() {
//		if (x != snakeX && y != snakeY) {
//			// draw apple at x and y
//			// repaint screen
//		} else {
//			randomX();
//			randomY();
//			spawnWall();
//		}
//	}
}
