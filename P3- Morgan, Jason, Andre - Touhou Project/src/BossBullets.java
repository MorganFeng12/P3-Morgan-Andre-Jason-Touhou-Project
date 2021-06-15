public class BossBullets extends Sprite{

    public BossBullets(String fileName) {
        super(fileName);
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