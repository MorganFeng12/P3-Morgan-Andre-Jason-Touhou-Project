
public class Bullets extends Sprite {
	//reads the file
	public Bullets(String fileName) {
		super(fileName);
		//instantiation of all the instance variables
		vx = 4;
		width = 10;
		height = 25;
		

		Enemy = false;
		bullet = true;

	}

}

