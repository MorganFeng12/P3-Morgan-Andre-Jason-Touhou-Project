import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	// handles drawing animation
	Timer animationTimer;
	Desert d;
	Background i;
	Background forest;
	Character c;
	Font verdana = new Font("Verdana", Font.BOLD, 80);
	Font verdana1 = new Font("Verdana", Font.BOLD, 50);
	Font verdana2 = new Font("Verdana", Font.BOLD, 35);
	int count = 0;
	int boss = 0;
	Heart h1, h2, h3;
	Sasuke s;
	Sasuke s2;
	Music m1, m2;
	int score = 0;

	int lives = 0;
	int mouseclicked = 0;
	// Enemy[] enemies = new Enemy[10];
	// AndreEnemy e;
	Player p1;
	Ball2[] obj;
	Ball3[] obj2;
	Ball4[] obj3;
	Enemy[] enemies = new Enemy[10];
	Enemy e1 = new Enemy("FlyingBat125.gif");
	Enemy e2 = new Enemy("FlyingBat125.gif");
	Enemy e3 = new Enemy("FlyingBat125.gif");
	Enemy e4 = new Enemy("FlyingBat125.gif");
	Enemy e5 = new Enemy("FlyingBat125.gif");
	Enemy e6 = new Enemy("FlyingBat125.gif");
	Enemy e7 = new Enemy("FlyingBat125.gif");
	Enemy e8 = new Enemy("FlyingBat125.gif");
	Enemy e9 = new Enemy("FlyingBat125.gif");
	Enemy e10 = new Enemy("FlyingBat125.gif");

	Boss boss1;

	int cntr = 0;

	Bullets b;
	EnemyBullets b1 = new EnemyBullets("Fireball.png");
	EnemyBullets b2 = new EnemyBullets("Fireball.png");
	EnemyBullets b3 = new EnemyBullets("Fireball.png");
	EnemyBullets b4 = new EnemyBullets("Fireball.png");
	EnemyBullets b5 = new EnemyBullets("Fireball.png");
	EnemyBullets b6 = new EnemyBullets("Fireball.png");
	EnemyBullets b7 = new EnemyBullets("Fireball.png");
	EnemyBullets b8 = new EnemyBullets("Fireball.png");
	EnemyBullets b9 = new EnemyBullets("Fireball.png");
	EnemyBullets b10 = new EnemyBullets("Fireball.png");

	public void paint(Graphics g) {
		super.paintComponent(g);


		if (boss == 0) {
			d.paint(g);
		}
		else {
			i.paint(g);
		}
	
	
		if (count == 0) {
			g.setFont(verdana);
			g.setColor(Color.blue);
			g.drawString("Touhou Project", 55, 200);
			g.setFont(verdana1);
			g.setColor(Color.orange);
			g.fillRect(220, 335, 360, 100);
			g.setColor(Color.black);
			g.drawString("Start Game", 240, 400);
		}


		if (count == 1) {

			for (int i = 0; i < enemies.length; i++) {
				enemies[i].paint(g);

			}
			s.paint(g);

			b.paint(g);
			e1.paint(g);
			e2.paint(g);
			e3.paint(g);
			e4.paint(g);
			e5.paint(g);
			e6.paint(g);
			e7.paint(g);
			e8.paint(g);
			e9.paint(g);
			e10.paint(g);
			b1.paint(g);
			b2.paint(g);
			b3.paint(g);
			b4.paint(g);
			b5.paint(g);
			b6.paint(g);
			b7.paint(g);
			b8.paint(g);
			b9.paint(g);
			b10.paint(g);
			for (int i = 0; i < enemies.length; i++) {

				if (b.collide(enemies[i])) {

					System.out.println("Hi");

					enemies[i].setX(-5000);
					enemies[i].setY((int) (Math.random() * 10000));
					score++;
				}


			}

			int sX = s.getX();
			int sY = s.getY();
			// s.paint(g);
			h1.paint(g);
			h2.setX(h1.getX() + 45);
			h2.paint(g);
			h3.setX(h2.getX() + 45);
			h3.paint(g);
			g.setFont(verdana2);
			g.setColor(Color.black);
			g.drawString("Lives: ", 15, 45);
			g.drawString("Score: " + score, 300, 45);

			for (int i = 0; i < enemies.length; i++) {
				enemies[i].paint(g);
			}

			s.paint(g);

			b.paint(g);

			for (int i = 0; i < enemies.length; i++) {

				if (b.collide(enemies[i])) {
					cntr++;

					enemies[i].setX(-5000);
					enemies[i].setY((int) (Math.random() * 10000));
					score++;

				}
				if (b.getX() >= 800) {
					cntr++;
					System.out.println("2");
				}
			}

			int e1X = e1.getX();
			int e1Y = e1.getY();
			int e2X = e2.getX();
			int e2Y = e2.getY();
			int e3X = e3.getX();
			int e3Y = e3.getY();
			int e4X = e4.getX();
			int e4Y = e4.getY();
			int e5X = e5.getX();
			int e5Y = e5.getY();
			int e6X = e6.getX();
			int e6Y = e6.getY();
			int e7X = e7.getX();
			int e7Y = e7.getY();
			int e8X = e8.getX();
			int e8Y = e8.getY();
			int e9X = e9.getX();
			int e9Y = e9.getY();
			int e10X = e10.getX();
			int e10Y = e10.getY();
			
			b1.update(e1X, e1Y);
			b2.update(e2X, e2Y);
			b3.update(e3X, e3Y);
			b4.update(e4X, e4Y);
			b5.update(e5X, e5Y);
			b6.update(e6X, e6Y);
			b7.update(e7X, e7Y);
			b8.update(e8X, e8Y);
			b9.update(e9X, e9Y);
			b10.update(e10X, e10Y);
			

			b.update(sX + 150, sY + 60);
			int sX1 = s.getX();
			int sY1 = s.getY();

			b.update(sX1 + 150, sY1 + 60);

			if (score > 5) {
				boss1.setX(570);
				boss1.setY(200);
				boss1.paint(g);
				//boss++;
				boss1.update();
			}

		}

		if (score > 20) {
			count++;

			g.setColor(Color.orange);
			g.fillRect(70, 130, 650, 300);
			g.setFont(verdana);
			g.setColor(Color.black);
			g.drawString("Game Over", 142, 250);
			g.drawString("Good Job!", 168, 350);
			g.setColor(Color.orange);
			g.fillRect(200, 450, 400, 110);
			g.setFont(verdana1);
			g.setColor(Color.black);
			g.drawString("Play Again", 250, 520);

		}

		/*
		 * if(lives == 0) {
		 * 
		 * g.setColor(Color.orange); g.fillRect(70, 130, 650, 300); g.setFont(verdana);
		 * g.setColor(Color.black); g.drawString("Game Over", 142, 250);
		 * g.setFont(verdana1); g.drawString("Try Again Next Time!", 100, 350);
		 * 
		 * }
		 */
	}

	public Driver() {
		JFrame f = new JFrame("Touhou Project");
		f.setSize(800, 600); // width and height

		// set default action for x button
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add this panel to the JFrame
		// allows connection with "drawing"
		f.add(this);

		// connect JFrame to keyboard listening code
		f.addKeyListener(this);

		// connect JFrame to mouse listening code
		f.addMouseListener(this);

		// connect JFrame to MouseMotionListener if necessary

		// setup animation timer
		animationTimer = new Timer(16, this);

		// connect JFrame to MouseMotionListener if necessary

		// setup animation timer
		// animationTimer = new Timer(30, this);

		// setup animation timer
		// animationTimer = new Timer(16, this);

		animationTimer.start();

		// instantiate the rest of the instance variables

		s = new Sasuke("Sasuke.png");
		b = new Bullets("Fireball.png");

		i = new Background("ice1.gif");
		forest = new Background("Forest.gif");
		d = new Desert("desert1.gif");

		m1 = new Music("Naruto1.wav", true);
		m1.play();

		h1 = new Heart("heart (2).png");
		h2 = new Heart("heart (2).png");
		h3 = new Heart("heart (2).png");

		obj = new Ball2[10];
		obj2 = new Ball3[10];
		obj3 = new Ball4[10];

		// -------------------------------

		p1 = new Player("Sasuke.png");

		boss1 = new Boss("naruto.png");

		// e = new AndreEnemy();

		for (int i = 0; i < 10; i++) {
			obj[i] = new Ball2();
		}

		for (int j = 0; j < 10; j++) {
			obj2[j] = new Ball3();
		}

		for (int k = 0; k < 10; k++) {
			obj3[k] = new Ball4();
		}

		// m1.play();


		for (int i = 0; i < enemies.length; i++) {
			enemies[i] = new Enemy("Flyingbat125.gif");

		}

		f.setVisible(true);

	}

	// stuff for collision

	/* this method is invoked/called by the timer */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		// call the frame to refresh
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		switch (arg0.getKeyCode()) {
		case 87:

			// move the left paddle up
			b.moveUp();
			// System.out.println("case 87");

			// move the avatar up and down
			// s.moveUp();
			System.out.println("case 87");

			// move the avatar up and down
			s.moveUp();

			break;
		case 83:
			s.moveDown();

			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	// motion

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		if (count == 0) {
			Rectangle bR = new Rectangle(220, 365, 360, 150);
			Rectangle mR = new Rectangle(m.getX(), m.getY(), 200, 140);

			if (bR.intersects(mR)) {
				mouseclicked++;
			}
			if (mouseclicked == 1) {
				count++;
			}
		}
		
		else {
			Rectangle bR1 = new Rectangle(200, 450, 400, 110);
			Rectangle mR1 = new Rectangle(m.getX(), m.getY(), 400, 110);
			if (bR1.intersects(mR1)) {
				count = 0;
				boss = 0;
				score = 0;
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}