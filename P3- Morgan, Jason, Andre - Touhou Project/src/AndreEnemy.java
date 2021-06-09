import java.awt.Color;
import java.awt.Graphics;

public class AndreEnemy { //the moving block on the right where the bullets shoot out from
	private int x, y; //location
	private int width, height;
	private Color c;
	private int vy;
	
	public AndreEnemy() {
		x = 700;
		y = 200;
		width = 50;
		height = 100;
		c = new Color(50,50,50);
		
		vy = 3;
		
	
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void paint(Graphics g) {
		
		update();
		g.setColor(this.c);
		g.fillRect(x, y, width, height);
		
	}
	
	public void update() {
	
		y -= vy;
		if ( y >= 400 || y <= 100 ) {
			vy*=-1;
		}
	}
}