import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	private final int width = 1400;
	private final int height = 750;
	private final int foodSize = 50;
	private final int maxBody = 900;
	private final int speed = 140;

	private final int x[] = new int[maxBody];
	private final int y[] = new int[maxBody];

	private int dots;
	private static int appleX;
	private static int appleY;
	private static int ratX;
	private static int ratY;

	private boolean leftKey = false;
	private boolean rightKey = true;
	private boolean upKey = false;
	private boolean downKey = false;
	private boolean inGame = true;
	private boolean ratSpawn = false;

	private Timer timer;
	private Image ball;
	private Image apple;
	private Image head;
	private Image eagle;
	private Image rat;

	static AudioStream appleSound;
	static AudioStream ratSound;

	public static int points = 0;
	public static String score = Integer.toString(points);

	Font myFont = new Font("Serif", Font.BOLD, 50);

	public Board() {

		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		setFocusable(true);

		setPreferredSize(new Dimension(width, height));
		images();
		initGame();
	}

	private void images() {

		try {
			ball = ImageIO.read(Board.class.getResourceAsStream("/dot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			apple = ImageIO.read(Board.class.getResourceAsStream("/apple.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			head = ImageIO.read(Board.class.getResourceAsStream("/head.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			rat = ImageIO.read(Board.class.getResourceAsStream("/rat.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initGame() {

		dots = 3;

		for (int z = 0; z < dots; z++) {
			x[z] = 50 - z * 10;
			y[z] = 50;
		}
		
		Apple.appleEat();
		Rat.ratEat();

		timer = new Timer(speed, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawing(g);

		Graphics2D g2d = (Graphics2D) g;
		Image Eagle = null;
		try {
			Eagle = ImageIO.read(Board.class.getResourceAsStream("/eagle.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image Snake = null;
		try {
			Snake = ImageIO.read(Board.class.getResourceAsStream("/snake.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g2d.drawImage(Eagle, 400, 50, 100, 100, this);
		g2d.drawImage(Snake, 30, 10, 80, 80, this);

		g2d.setColor(Color.GREEN);
		g2d.drawRect(30, 90, 1150, 580);// 590
		g2d.setColor(Color.RED);

		// (?,?,width of line, angle)
		g2d.drawLine(30, 530, 30, 670);
		g2d.drawLine(1180, 530, 1180, 670);

		g.setColor(Color.WHITE);
		g.setFont(myFont);
		g.drawString("Snake Game: ", 130, 60);
		g.drawString("Score: ", 800, 60);
		g.drawString(score, 950, 60);

	}

	private void drawing(Graphics g) {

		if (inGame) {

			g.drawImage(apple, appleX, appleY, this);

			if (ratSpawn == true) {
				g.drawImage(rat, ratX, ratY, this);
			}

			for (int z = 0; z < dots; z++) {
				if (z == 0) {
					g.drawImage(head, x[z], y[z], this);
				} else {
					g.drawImage(ball, x[z], y[z], this);
				}
			}

			Toolkit.getDefaultToolkit().sync();

		} else {

			gameOver(g);
		}
	}

	private void gameOver(Graphics g) {

		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.BLACK);
		g.setFont(small);
		g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 2);
	}

	private void eat() {
		if ((x[0] == appleX) && (y[0] == appleY)) {
			dots++;
			Apple.appleEat();
			Random rand = new Random();
			int ratChance = rand.nextInt(100);
			if (ratChance < 21) {
				ratSpawn = true;
			} else {
				if (ratSpawn == true) {
					ratSpawn = true;
				} else {
					ratSpawn = false;
				}
			}
		}
		if ((x[0] == ratX) && (y[0] == ratY && ratSpawn == true)) {
			dots++;
			Rat.ratEat();
			ratSpawn = false;
		}
	}

	private void move() {

		for (int z = dots; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (leftKey) {
			x[0] -= foodSize;
		}

		if (rightKey) {
			x[0] += foodSize;
		}

		if (upKey) {
			y[0] -= foodSize;
		}

		if (downKey) {
			y[0] += foodSize;
		}
	}

	private void collision() {

		for (int z = dots; z > 0; z--) {

			if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
				inGame = false;
			}
		}

		if (y[0] >= height) {
			inGame = false;
		}

		if (y[0] < 0) {
			inGame = false;
		}

		if (x[0] >= width) {
			inGame = false;
		}

		if (x[0] < 0) {
			inGame = false;
		}

		if (!inGame) {
			timer.stop();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (inGame) {
			eat();
			collision();
			move();
		}

		repaint();
	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!rightKey)) {
				leftKey = true;
				upKey = false;
				downKey = false;
			}

			if ((key == KeyEvent.VK_RIGHT) && (!leftKey)) {
				rightKey = true;
				upKey = false;
				downKey = false;
			}

			if ((key == KeyEvent.VK_UP) && (!downKey)) {
				upKey = true;
				rightKey = false;
				leftKey = false;
			}

			if ((key == KeyEvent.VK_DOWN) && (!upKey)) {
				downKey = true;
				rightKey = false;
				leftKey = false;
			}
		}
	}

	public static void setPoints(int newPoints) {
		points = newPoints;
	}

	public static int getPoints() {
		return points;
	}

	public static void setAppleX(int appleXNew) {
		appleX = appleXNew;
	}

	public static void setAppleY(int appleYNew) {
		appleY = appleYNew;

	}

	public static void setRatX(int ratXNew) {
		ratX = ratXNew;
	}

	public static void setRatY(int ratYNew) {
		ratY = ratYNew;
	}

}