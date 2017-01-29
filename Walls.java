// Team SNAP
// Pranav G, Maryam S, Ajay G and Jennifer N.
// Snake Game
// This program is a reimagining of the classic game: "Snake"
// 25 January 2017
import java.io.FileInputStream;

import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Walls extends NonMoving {
	String wall = "image of wall";
	AudioStream hitSound;

	public Walls() {
	}

	public void hitWall() {
		// initializing the name of the sound for when the snakes hits the wall or the obstacle
		try {
			AudioStream hitSound;
			hitSound = new AudioStream(new FileInputStream("Hit Sound.wav"));
			this.hitSound = hitSound;
		} catch (Exception ex) {
			// print this if the sound doesnt run
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	// public void spawnWall() {
	// if (x != snakeX && y != snakeY) {
	// // draw apple at x and y
	// // repaint screen
	// } else {
	// randomX();
	// randomY();
	// spawnWall();
	// }
	// }
}
