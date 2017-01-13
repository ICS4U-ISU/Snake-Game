
public class Apple extends Food{
	// Image of apple
	int currentPoints;
	int snakeX;
	int snakeY;
	
	public Apple(){
	}
	
	public void spawnApple(){
		randomX();
		randomY();
		if (x != snakeX && y != snakeY){
			// draw apple at x and y
			// repaint screen
		} else {
			randomX();
			randomY();
			spawnApple();
		}
	}
	
	public void appleEat(){
		// Will only run if collision is true
		currentPoints = GamePanel.getPoints();
		GamePanel.setPoints(currentPoints + pointsApple);
		spawnApple();
	}
}
