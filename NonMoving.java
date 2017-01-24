import java.util.Random;

@SuppressWarnings("serial")
public class NonMoving extends Board {
	static int x;
	static int y;
	boolean collision;
	int currentPoints;
	int width = 1200;
	static int height = 690;

	public NonMoving(int currentPoints) {
		Random rand = new Random();
		x = rand.nextInt(width);
		y = rand.nextInt(height);
		collision = false;
		this.currentPoints = currentPoints;
	}

	public static int randomX() {
		Random rand = new Random();
		int x = rand.nextInt(height);
		return x;
	}

	public static int randomY() {
		Random rand = new Random();
		int y = rand.nextInt(height);
		return y;
	}
}