import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public abstract class Sprite {
	protected Image img; // image for sprite
	protected Image alternate;
	protected int x, y; // location
	protected boolean Enemy;
	protected boolean bullet;
	protected int vx, vy;
	protected int width;
	protected int height;
	protected int stopDist;
	protected int sX, sY;

	public Sprite(String fileName) {
		// assignment statements for attributes
		img = getImage(fileName); // load the image

		init(x, y); // initialize the x,y position of the image

	}

	public int getX() {
		return x;
	}
	public int getVX() {
		return vx;
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
	
	public void bulletUpdate() {
		x = 850;
	}

	// gets image and process it
	public void update() {
		tx.setToTranslation(x, y);
		x += vx;
		y += vy;
		if (x < stopDist && Enemy && vx != 0) {
			vx = 0;
			vy = (int) (Math.random() * 14 - 7);
			while (vy <= 3 && vy >= -3) {
				vy = (int) (Math.random() * 14 - 7);
			}
			

		}
		if (y <= -25 || y >= 500 && Enemy) {
			vy *= -1;
		}
		
		if (bullet && x >= 800) {
			x = sX;
			y = sY;
		}
		

	}

	public void moveUp() {
		if (y > 0) {
			y -= 16;
		}
	}

	public void moveDown() {
		if (y < 430) {
			y += 16;
		}
	}

	public void update(int x1, int y1) {
		sX = x1;
		sY = y1;

	}

	public boolean collide(Bullets obj) {

		// represent both objects as Rectangles,
		// use the intersect command to check for collision

		Rectangle r1 = new Rectangle(x, y, width, width);

		// r2 is Ball2
		Rectangle r2 = new Rectangle(obj.getX(), obj.getY(), obj.getWidth(), obj.getWidth());



		return r1.intersects(r2);
	}

	public boolean collide(Sasuke obj2) {

		// represent both objects as Rectangles,
		// use the intersect command to check for collision

		Rectangle r1 = new Rectangle(x, y, width, width);

		// r2 is Ball3
		Rectangle r2 = new Rectangle(obj2.getX(), obj2.getY(), obj2.getWidth(), obj2.getWidth());



		return r1.intersects(r2);
	}

	public boolean collide(Enemy obj3) {

		// represent both objects as Rectangles,
		// use the intersect command to check for collision

		Rectangle r1 = new Rectangle(x, y, width, width);

		// r2 is Ball4
		Rectangle r2 = new Rectangle(obj3.getX(), obj3.getY(), obj3.getWidth()-40, obj3.getWidth()-40);



		return r1.intersects(r2);
	}
	

	public boolean collide(EnemyBullets obj3) {

		// represent both objects as Rectangles,
		// use the intersect command to check for collision

		Rectangle r1 = new Rectangle(x, y, width, width);

		// r2 is Ball4
		Rectangle r2 = new Rectangle(obj3.getX(), obj3.getY(), obj3.getWidth(), obj3.getWidth());


		return r1.intersects(r2);

	}

	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	// draw the affine transform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);
		
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
		Rectangle temp = new Rectangle(x, y, width, height);
		return temp;
	}

}

