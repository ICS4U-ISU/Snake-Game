// Team SNAP
// Pranav G, Maryam S, Ajay G and Jennifer N.
// Snake Game
// This program is a reimagining of the classic game: "Snake"
// 25 January 2017

import java.awt.EventQueue;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Snake extends JFrame {
	/**
	 * Sets basic settings for the game board that the game will run in
	 */
	public Snake() {
		// adds new board and packs it
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
	 * @param args
	 *            An array of arguments
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
