import java.awt.Graphics;
import java.awt.Graphics2D;

public class Boss extends Sprite {
	public Boss(String fileName) {
		super(fileName);
		vy = 0;
		vx = -7;
		x = 750;
		y = (int) (Math.random() * 450 - 25);
		stopDist = (int) (Math.random() * 301 + 425);
		Enemy = true;
	}
	public int getX() {
		return x;
	}

}
