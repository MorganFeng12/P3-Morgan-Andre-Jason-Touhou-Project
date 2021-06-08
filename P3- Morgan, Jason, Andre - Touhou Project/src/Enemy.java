
public class Enemy extends Sprite{


	public Enemy(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
		vy = 0;
		vx = (int) (Math.random()*10);
		x =500;
		y = (int) (Math.random()* 600-75);
		width = 150;
		height = 150;
	}
	


}
