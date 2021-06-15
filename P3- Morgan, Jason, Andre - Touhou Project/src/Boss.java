import java.awt.Graphics;
import java.awt.Graphics2D;

public class Boss extends Sprite {
	public Boss(String fileName) {
		super(fileName);
		vy = 3;
		vx = -7;
		x = 580;
		y = 250;
		width = 150;
		height = 150;
		stopDist = 580;
		Enemy = true;
		bmove = true;
		bullet = false;
	}
	
	public int getX() {
		return x;
	}

}
