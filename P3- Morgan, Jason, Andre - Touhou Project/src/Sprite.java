
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public abstract class Sprite{
	protected Image img; // image for sprite
	protected Image alternate;
	protected int x, y; // location
	protected boolean Enemy;
	protected int vx, vy;
	protected int width; 
	protected int height;
	protected int stopDist;

	public Sprite(String fileName) {
		// assignment statements for attributes
		img = getImage(fileName); //load the image

		init(x, y); //initialize the x,y position of the image

	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setStopDist(int stopDist) {
		this.stopDist = stopDist;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// gets image and process it
	public void update() {
		tx.setToTranslation(x, y);
		x += vx;
		y += vy;
		if (x < stopDist && Enemy && vx != 0) {
			vx = 0;
			vy = (int) (Math.random()*20-10);
			while (vy <= 5 && vy >= -5) {
				vy = (int) (Math.random()*20-10);
			}
			
		}
		if (y <=  -25|| y >= 500 && Enemy) {
			vy *= -1;
		}
	}
	
	
	public void moveUp() {

		y -= 15;

		if (y > 0) {
		y -= 8;
		}

	}
	
	public void moveDown() {

		y += 15;

		if (y < 430) {
		y += 8;
		}

	}

	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	// draw the affine transform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);
		

        if(y < 0) {
			y = 0;
		}
		if (y > 430) {
			y = 430;
		}
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	// converts image to make it drawable in paint
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Sprite.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	/* Helper function for collision detection later */
	public Rectangle getRect() {
		Rectangle temp = new Rectangle(x,y,width,height);
		return temp;
	}

}