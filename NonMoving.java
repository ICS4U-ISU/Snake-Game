import java.util.Random;

@SuppressWarnings("serial")
public class NonMoving extends GamePanel {
	static int x;
	static int y;
	boolean collision;
	int snakeX;
	int snakeY;
	int currentPoints;
	int width = 1200; //700 is the width of the game panel
	static int height = 690; //500 is the height of the game panel

	public NonMoving(int snakeX, int snakeY, int currentPoints) {
		Random rand = new Random();
		x = rand.nextInt(width);
		y = rand.nextInt(height);
		collision = false;
		this.snakeX = snakeX;
		this.snakeY = snakeY;
		this.currentPoints = currentPoints;
	}

	public static void randomX() {
		Random rand = new Random();
		int x = rand.nextInt(height); // 700 is the width of the panel
		NonMoving.x = x;
	}

	public static void randomY() {
		Random rand = new Random();
		int y = rand.nextInt(height);
		NonMoving.x = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		NonMoving.x = x;
	}

	public void setY(int y) {
		NonMoving.y = y;
	}
}