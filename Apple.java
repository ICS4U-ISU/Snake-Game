
public class Apple extends Food{
	// Image of apple
	int currentPoints;
	
	public Apple(){
		points = 20;
	}
	
	public void spawnApple(){
		randomX();
		randomY();
		// if x != where snake is and y != where snake is
			// draw rat at x and y
	}
	
	public void appleEat(){
		// Will only run if collision is true
		currentPoints = GamePanel.getPoints();
		GamePanel.setPoints(currentPoints + points);
		spawnApple();
	}
}
