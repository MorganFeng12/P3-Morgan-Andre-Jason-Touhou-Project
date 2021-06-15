
public class EnemyBullets extends Sprite {

	public EnemyBullets(String fileName) {
		super(fileName);

		width = 25;
		height = 25;
		x = 750;
		y = (int) (Math.random()*700);
		vx = -8;

		Enemy = false;
		bullet = true;
	}

}
