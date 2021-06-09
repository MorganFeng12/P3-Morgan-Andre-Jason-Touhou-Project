import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class Ball4 { //3rd line of balls that shoot out from the block
	
	//instance variables
	private int x, y; //location
	private int radius;//radius
	private int vx, vy; //movement variables
	private Color color; //color
	private double a;
	private int ex, ey;
	//add the constructor header and body
	//give initial values for x, y, and a radius of 50
	
	
	public Ball4() {
		
		//randomize the location of every
		//Enemy object to be in the 800x600 frame
		
		x = 700;
		y = 200;
		vx = 5;
		vy = (int)(Math.random()*9)-4;
		radius = 10;
		
		//randomize enemy color
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		color = new Color(red, green, blue);
		
	} 
	
	
	
	
	
	
	
	
	
	
	// --------------------------------> stuff for collision <-----------------------------------------
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
			vx = 8;
		}
		
	}


	

}