import java.io.FileInputStream;
import java.util.Random;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class NonMoving extends Board {
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
	public static void appleRandomizer() {
		try {
			appleSound = new AudioStream(new FileInputStream("H:/git/Snake-Game/Apple Sound.wav"));
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();	
		}
		AudioPlayer.player.start(appleSound);
	}

	public static int randomX() {
		Random rand = new Random();
		int x = rand.nextInt(height); // 700 is the width of the panel
		return x;
	}

	public static int randomY() {
		Random rand = new Random();
		int y = rand.nextInt(height);
		return y;
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