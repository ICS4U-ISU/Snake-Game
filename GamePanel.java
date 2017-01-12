// hi
//dsfndslknflksf
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	public static int width = 700;
	public static int height = 500;


	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		//g2d.fillOval(0, 0, 30, 30);
		//g2d.drawOval(0, 50, 30, 30);		
		g2d.drawRect(30, 70, 640, 400);
		g2d.drawRect(30, 390, 640, 80);
		g2d.drawRect(30, 390, 640, 80);
		//g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	

	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));
		frame.setAutoRequestFocus(false);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.add(new GamePanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	public GamePanel(){
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);

	}
}