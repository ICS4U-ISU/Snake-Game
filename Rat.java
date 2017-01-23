import sun.audio.AudioPlayer;

@SuppressWarnings("serial")
public class Rat extends Food {
	// Image of rat
	// Audio of rat

	public Rat(int snakeX, int snakeY, int currentPoints) {
		super(snakeX, snakeY, currentPoints);
	}

	public void spawnRat() {
		randomX();
		randomY();
		if (x != snakeX && y != snakeY) {
			// draw rat at x and y
			// repaint screen
		} else {
			randomX();
			randomY();
			spawnRat();
		}
	}

	public void ratEat() {
		AudioPlayer.player.start(ratSound);
		currentPoints = Board.getPoints();
		Board.setPoints(currentPoints + pointsRat);
		spawnRat();
	}
}
