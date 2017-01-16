import java.util.Random;

public class Food extends NonMoving {

	// Audio for eating something
	int pointsRat = 100;
	int pointsApple = 20;
	boolean rat;

	public void randomRat(){
		Random rand = new Random();
		int random = rand.nextInt(10);
		if (random > 2){
			rat = false;
		} else {
			rat = true;
		}
	}
		
	public boolean getRat(){
		return rat;
	}
}
