import java.awt.Graphics;
import java.awt.Graphics2D;

public class Enemy extends Sprite {

	public Enemy(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
		vy = 0;
		vx = -7;
		x = 1000;
		y = (int) (Math.random() * 450 - 25);
		width = 150;
		height = 150;
		stopDist = (int) (Math.random() * 301 + 425);
		Enemy = true;
		bmove = false;
		bullet = false;


	}

	public int getX() {
		return x;
	}

}
