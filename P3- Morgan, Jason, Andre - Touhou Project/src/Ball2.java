import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class Ball2 { //the balls that shoot out from the block
	
	//ball2, ball3, and ball4 r supposed to be the bullets
	
	//instance variables
	private int x, y; 
	private int radius;
	private int vx, vy; 
	private Color color;
	private double a;
	private int ex, ey;
	
	 
	
	
	public Ball2() {
		
		
		x = 700;
		y = 200;
		vx = 8;
		vy = (int)(Math.random()*9)-4;
		radius = 10;
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		color = new Color(red, green, blue);
		
	} 
	
	
	
	
	
	
	
	// write the getters for all attributes
	// ------------------------------------> stuff for collision <-------------------------------------
	public int getWidth() {
		return radius;
	}

	// write the setters for x
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	// write the setters for x and y
	public void setX(int newX) {
		x = newX;
	}
	public void setY(int newY) {
		y = newY;
	}
	public void setWidth(int newWidth) {
		radius = newWidth;
	}
	
	
	
	
	
	
	
	
	public void paint(Graphics g) {
		
		update(); 
		
		Graphics2D g2 = (Graphics2D) g;
		//call fillOval here
		g2.fillOval(x, y, radius*2, radius*2);
		g2.setColor(color);
	

	}

	
	public void update(int x1, int y1) {
		ex=x1;
		ey=y1;

	}
	
	public void update() {
		x -= vx;
		y -= vy;
		
		if ( x>=800 || x <= 0 ) {
			y = ey;
			x = ex;
		}
		
	}


	

}