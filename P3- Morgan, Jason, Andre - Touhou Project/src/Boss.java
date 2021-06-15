import java.awt.Graphics;
import java.awt.Graphics2D;

public class Boss extends Sprite {
	public Boss(String fileName) {
		super(fileName);
		vy = 3;
		vx = -7;
		x = 600;
		y = (int) (Math.random() * 450 - 25);
		width = 150;
		height = 150;
		stopDist = (int) (Math.random() * 301 + 425);
		Enemy = true;
		bmove = true;
		bullet = false;
	}
	
	public int getX() {
		return x;
	}

}
