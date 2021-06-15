
public class EnemyBullets extends Sprite {
	//reads in the file
	public EnemyBullets(String fileName) {
		super(fileName);
		//sets all of the instance variables to their right balue
		width = 25;
		height = 25;
		x = 750;
		y = (int) (Math.random()*700);
	
		vx = (int) (Math.random()*2 - 7);
	
		Enemy = false;
		bullet = true;
	}

}
