public class BossBullets extends Sprite{
	//reads the file
    public BossBullets(String fileName) {
        super(fileName);
        //instantiating all of the instance variables to their desired value for boss bullets
        width = 25;
        height = 25;
        x = 750;
        y = 250;
        vx = -8;
        vy = (int) (Math.random()*10-5);

        Enemy = false;
        bullet = true;
        bmove = false;
        }
}