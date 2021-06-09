import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Ball extends Sprite{
    private int x, y; //location
    private int width;
    private Color c;
    
// -------------------------> the ball is the player <------------------------------------------
    public Ball(String fileName) {
    	super(fileName);
        x = 20;
        y = 250;
        width = 50;
        c = new Color(50,50,50);
    
        


    }
    
    
    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }

    /*
    public void paint(Graphics g) {

        g.setColor(this.c);
        g.fillOval(x, y, width, width);



    }
	
	*/
	
	
	//---------------------------------------------------------------> stuff for collision <-----------------------------------------------------------------
    
    public void setX(int newX) {
    	x = newX;
    }
    public void setY(int newY) {
    	y = newY;
    }
    public void setWidth(int newWidth) {
    	width = newWidth;
    }
    
	public int getWidth() {
		return width;
	}

    public boolean collide(Ball2 obj) {
    	
    	//represent both objects as Rectangles, 
    	//use the intersect command to check for collision
    	
    	Rectangle r1 = new Rectangle(x, y, width, width); 
    	
    	//r2 is Ball2
    	Rectangle r2 = new Rectangle(obj.getX(), obj.getY(), 
    			obj.getWidth(), obj.getWidth());
    	
    	if(r1.intersects(r2)) {
    		//do something    
    		
    	}
    	
    	return r1.intersects(r2);
    }
    
    public boolean collide(Ball3 obj2) {
    	
    	//represent both objects as Rectangles, 
    	//use the intersect command to check for collision
    	
    	Rectangle r1 = new Rectangle(x, y, width, width); 
    	
    	//r2 is Ball3
    	Rectangle r2 = new Rectangle(obj2.getX(), obj2.getY(), 
    			obj2.getWidth(), obj2.getWidth());
    	
    	if(r1.intersects(r2)) {
    		//do something    
    		
    	}
    	
    	return r1.intersects(r2);
    }
    
   public boolean collide(Ball4 obj3) {
    	
    	//represent both objects as Rectangles, 
    	//use the intersect command to check for collision
    	
    	Rectangle r1 = new Rectangle(x, y, width, width); 
    	
    	//r2 is Ball4
    	Rectangle r2 = new Rectangle(obj3.getX(), obj3.getY(), 
    			obj3.getWidth(), obj3.getWidth());
    	
    	if(r1.intersects(r2)) {
    		//do something    		
    	}
    	
    	return r1.intersects(r2);
    }

}