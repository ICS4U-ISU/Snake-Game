import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {


	public static int width = 1200;
	public static int height = 690;
	public static int points = 0;
	public static String score = Integer.toString(points);

	Font myFont = new Font("Serif", Font.BOLD, 50);




	@Override
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		Image jpgImage;
		jpgImage = Toolkit.getDefaultToolkit ().getImage ("/Eagle.jpg");
		g2d.drawImage (jpgImage, 400,50, 100, 100, null);

		g2d.setColor(Color.GREEN);
		g2d.drawRect(30, 90, 1150, 580);//590
		g2d.setColor(Color.RED);

		//(?,?,width of line, angle)
		g2d.drawLine(30, 530, 30, 670);
		g2d.drawLine(1180, 530, 1180, 670);
		g2d.setColor(Color.WHITE);
		g2d.setFont(myFont);
		g2d.drawString("Snake Game: ", 130, 60);
		g2d.drawString("Score: ", 800, 60);
		g2d.drawString(score, 950, 60);
		



	}


	public static void main(String[] args) {

		JFrame frame = new JFrame("Snake Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));
		frame.setAutoRequestFocus(false);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();
		frame.add(new GamePanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		Image jpgImage;
		jpgImage = Toolkit.getDefaultToolkit ().getImage ("Eagle.jpg");

	}
	public GamePanel(){
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);

	}

	public static void setPoints(int pointsToAdd){
		points = pointsToAdd;
	}

	public static int getPoints(){
		return points;
	}

}