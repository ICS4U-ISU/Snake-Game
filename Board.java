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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	/**
	 * Width of the game panel
	 */
	private final int width = 1400;
	/**
	 * Height of the game panel
	 */
	private final int height = 750;

	/**
	 * Size of a section in the panel
	 */
	private final int foodSize = 50;
	/**
	 * Max length of the snake
	 */
	private final int maxBody = 900;
	/**
	 * Timer speed
	 */
	private final int speed = 140;

	/**
	 * An array that stores the snake's body
	 */
	private final int x[] = new int[maxBody];
	/**
	 * An array that stores the snake's body
	 */
	private final int y[] = new int[maxBody];

	/**
	 * Number of snake segments
	 */
	private int dots;
	/**
	 * Apple x-coordinate
	 */
	private static int appleX;
	/**
	 * Apple y-coordinate
	 */
	private static int appleY;
	/**
	 * Rat x-coordinate
	 */
	private static int ratX;
	/**
	 * Rat y-coordinate
	 */
	private static int ratY;

	/**
	 * If the left key is pressed
	 */
	private boolean leftKey = false;
	/**
	 * If the right key is pressed
	 */
	private boolean rightKey = true;
	/**
	 * If the up key is pressed
	 */
	private boolean upKey = false;
	/**
	 * If the down key is pressed
	 */
	private boolean downKey = false;

	/**
	 * If the player is alive
	 */
	private boolean inGame = true;

	/**
	 * If the rat is allowed the spawn
	 */
	private boolean ratSpawn = false;

	/**
	 * Game timer
	 */
	private Timer timer;
	/**
	 * Snake's body
	 */
	private Image ball;
	/**
	 * Snake's food
	 */
	private Image apple;
	/**
	 * Snake's head
	 */
	private Image head;
	/**
	 * The rat, also a food for the snake
	 */
	private Image rat;

	/**
	 * Sound when the snake hits itself or a wall
	 */
	private Clip hitSound;

	/**
	 * Number of earned points
	 */
	public static int points = 0;
	/**
	 * String to display the score
	 */
	public static String score = Integer.toString(points);

	Font myFont = new Font("Serif", Font.BOLD, 50);

	/**
	 * Sets settings for the board
	 */
	public Board() {

		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		setFocusable(true);

		setPreferredSize(new Dimension(width, height));
		images();
		initGame();
	}

	/**
	 * Method that holds all of the images
	 */
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

	/**
	 * Starts the game
	 */
	private void initGame() {
		// Sets the number of starting segments of the snake
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

	/**
	 * Paints the board
	 */
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

		g2d.drawImage(Eagle, 30, 530, 100, 100, this);
		g2d.drawImage(Snake, 30, 10, 80, 80, this);

		g2d.setColor(Color.GREEN);
		g2d.drawRect(15, 90, 1200, 580);// 590
		g2d.setColor(Color.RED);

		// (?,?,width of line, angle)
		g2d.drawLine(15, 530, 15, 670);
		g2d.drawLine(1215, 530, 1215, 670);

		g.setColor(Color.WHITE);
		g.setFont(myFont);
		g.drawString("Snake Game: ", 130, 60);
		g.drawString("Score: ", 800, 60);
		g.drawString(score, 950, 60);

	}

	/**
	 * Draws the snake and the food
	 * 
	 * @param g
	 *            The board
	 */
	private void drawing(Graphics g) {

		if (inGame) {
			score = Integer.toString(points);
			g.drawString(score, 950, 60);

			g.drawImage(apple, appleX, appleY, this);

			if (ratSpawn == true) {
				g.drawImage(rat, ratX, ratY, this);
			}

			for (int z = 0; z < dots; z++) {
				if (z == 0) {
					g.drawImage(head, x[z], y[z] + 50, this);
				} else {
					g.drawImage(ball, x[z], y[z] + 50, this);
				}
			}

			Toolkit.getDefaultToolkit().sync();

		} else {

			gameOver(g);
		}
	}

	/**
	 * Display for when the snake dies
	 * 
	 * @param g
	 *            The board
	 */
	private void gameOver(Graphics g) {

		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.BLACK);
		g.setFont(small);
		g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 2);
	}

	/**
	 * Method for when the snake eats something
	 */
	private void eat() {
		if ((x[0] == appleX) && (y[0] == appleY - 50)) {
			dots++;
			Apple.appleEat();
			points = points + 50; // Adds points for eating apple
			// Sets if rat will spawn or not
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
		if ((x[0] == ratX) && (y[0] == ratY - 50 && ratSpawn == true)) {
			dots++;
			Rat.ratEat();
			ratSpawn = false; // Rat cannot spawn until this variable is changed
			points = points + 100; // Adds points for eating rat
		}
	}

	/**
	 * The method that moves the snake
	 */
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

	/**
	 * Method that is run every move to see is the snake hit a wall or itself
	 */
	private void collision() {
		// Prepares hit sound
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(Apple.class.getResource("Hit Sound.wav"));
			hitSound = AudioSystem.getClip();
			hitSound.open(audioIn);
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}

		// when the snake touches one of its joints it'll be game over
		for (int z = dots; z > 0; z--) {

			if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
				inGame = false;
				hitSound.start();
			}
		}
		// If the snake hits a wall
		if (y[0] >= 585) { // bottom line
			inGame = false;
			hitSound.start();
		}

		if (y[0] <= 49) { // top line
			inGame = false;
			hitSound.start();
		}

		if (x[0] >= 1180) { // right line
			inGame = false;
			hitSound.start();
		}

		if (x[0] <= 45.5) { // left line
			inGame = false;
			hitSound.start();
		}

		if (!inGame) {
			timer.stop();
		}

	}

	/**
	 * A method that is ran every time something happens
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (inGame) {
			eat();
			collision();
			move();
		}

		repaint();
	}

	/**
	 * KeyAdapter class for listening for key presses
	 *
	 */
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

	/**
	 * Sets a new apple X value
	 * 
	 * @param appleXNew
	 *            The new apple Y value
	 */
	public static void setAppleX(int appleXNew) {
		appleX = appleXNew + 50;
	}

	/**
	 * Sets a new apple Y value
	 * 
	 * @param appleYNew
	 *            The new apple Y value
	 */
	public static void setAppleY(int appleYNew) {
		appleY = appleYNew + 50;

	}

	/**
	 * Sets a new rat X value
	 * 
	 * @param ratXNew
	 *            The new rat X value
	 */
	public static void setRatX(int ratXNew) {
		ratX = ratXNew + 50;
	}

	/**
	 * Sets a new rat Y value
	 * 
	 * @param ratYNew
	 *            The new rat Y value
	 */
	public static void setRatY(int ratYNew) {
		ratY = ratYNew + 50;
	}

}