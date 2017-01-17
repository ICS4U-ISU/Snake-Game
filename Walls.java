
@SuppressWarnings("serial")
public class Walls extends NonMoving {
	String wall = "image of wall";

	public Walls(int snakeX, int snakeY, int currentPoints) {
		super(snakeX, snakeY, currentPoints);
	}

	public void spawnWall() {
		if (x != snakeX && y != snakeY) {
			// draw apple at x and y
			// repaint screen
		} else {
			randomX();
			randomY();
			spawnWall();
		}
	}
}
