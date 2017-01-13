
public class Rat extends Food{
	//Image of rat
	//Audio of rat
	int currentPoints;
	int snakeX;
	int snakeY;
	
	
	public void spawnRat(){
		randomX();
		randomY();
		if (x != snakeX && y != snakeY){
			//draw rat at x and y
			// repaint screen
		} else {
			randomX();
			randomY();
			spawnRat();
		}
	}
	
	public void appleEat(){
		// Will only run if collision is true
		currentPoints = GamePanel.getPoints();
		GamePanel.setPoints(currentPoints + pointsRat);
		spawnRat();
	}
}
