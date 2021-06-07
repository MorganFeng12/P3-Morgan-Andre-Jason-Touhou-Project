
public class Enemy extends Sprite{
	private int vy;
	private int vx;
	private int x;
	private int y;
	private int width;
	private int height;
	
	

	public Enemy(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
		vy = 0;
		vx = (int) (Math.random()*10);
		x = 1000;
		y = (int) (Math.random()*650);
		width = 150;
		height = 150;
	}

}
