// Team SNAP
// Pranav G, Maryam S, Ajay G and Jennifer N.
// Snake Game
// This program is a reimagining of the classic game: "Snake"
// 25 January 2017
@SuppressWarnings("serial")
public class Obstacles extends NonMoving {
	public Obstacles() {
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
