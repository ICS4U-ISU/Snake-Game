
@SuppressWarnings("serial")
public class NonMoving extends Board {

	/**
	 * Creates a random X value
	 * 
	 * @return A random X value
	 */
	public static int randomizerX() {
		int r = (int) (Math.random() * 10);
		int x = r * 50;
		while (x < 45.5 || x > 1180) {
			r = (int) (Math.random() * 10);
			x = r * 50;
		}
		return x;
	}

	/**
	 * Creates a random Y value
	 * 
	 * @return A random Y value
	 */
	public static int randomizerY() {
		int r = (int) (Math.random() * 10);
		int y = r * 50;
		while (y < 49 || y > 585) {
			r = (int) (Math.random() * 10);
			y = r * 50;
		}
		return y;
	}

}