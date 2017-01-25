import java.awt.EventQueue;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Snake extends JFrame {
	/**
	 * Sets basic settings for the game board that the game will run in
	 */
	public Snake() {

		add(new Board());

		setResizable(false);
		pack();

		setTitle("Snake Game");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Main method for starting the game
	 * 
	 * @param args args
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame ex = new Snake();
				ex.setVisible(true);
			}
		});
	}

}
