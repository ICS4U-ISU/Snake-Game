
public class Rat extends Food{
	//Image of rat
	//Audio of rat
	int currentPoints;
	
	public Rat(){
		points = 100;
	}
	
	public void spawnRat(){
		randomX();
		randomY();
		// if x != where snake is and y != where snake is
			// draw rat at x and y
		// else get new X and Y values
	}
	
	public void appleEat(){
		// Will only run if collision is true
		currentPoints = GamePanel.getPoints();
		GamePanel.setPoints(currentPoints + points);
		spawnRat();
	}
}
