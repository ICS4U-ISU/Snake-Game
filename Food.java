import java.util.Random;

public class Food extends NonMoving{
	
	//Audio for eating something
	int points;
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
	
}
