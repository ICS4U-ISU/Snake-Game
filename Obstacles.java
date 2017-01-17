
@SuppressWarnings("serial")
public class Obstacles extends NonMoving {
	public Obstacles(int snakeX, int snakeY, int currentPoints) {
		super(snakeX, snakeY, currentPoints);
	}

	boolean visibility;
	// Audio for hitting something

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public boolean getVisibility() {
		return visibility;
	}

}
