import sun.audio.AudioPlayer;

@SuppressWarnings("serial")
public class Apple extends Food {
	// Image of apple

	public Apple(int snakeX, int snakeY, int currentPoints) {
		super(snakeX, snakeY, currentPoints);
	}

	public void spawnApple() {
		randomX();
		randomY();
		if (x != snakeX && y != snakeY) {
			// draw apple at x and y
			// repaint screen
		} else {
			randomX();
			randomY();
			spawnApple();
		}
	}

	public void appleEat() {
		AudioPlayer.player.start(appleSound);
		currentPoints = Board.getPoints();
		Board.setPoints(currentPoints + pointsApple);
		spawnApple();
	}
}
