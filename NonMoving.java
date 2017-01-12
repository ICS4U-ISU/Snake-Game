import java.util.Random;

public class NonMoving {
	int x, y;
	boolean collision;
	int width = 1200; //700 is the width of the game panel
	int height = 690; //500 is the height of the game panel

	public NonMoving() {
		Random rand = new Random();
		x = rand.nextInt();
		y = rand.nextInt(500);
		collision = false;
	}

	public void randomX() {
		Random rand = new Random();
		int x = rand.nextInt(height); //700 is the width of the panel
		this.x = x;
	}

	public void randomY() {
		Random rand = new Random();
		int y = rand.nextInt(height);
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}