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
	Enemy[] enemies = new Enemy[20];

	Boss b1;

	int cntr = 0;

	Bullets b;

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
			int sX = s.getX();
			int sY = s.getY();

			b.update(sX + 150, sY + 60);

			if (score >= 20) {
				b1.setX(570);
				b1.setY(200);
				b1.paint(g);
				boss++;
				b1.update();
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

		b1 = new Boss("naruto.png");

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
		// update();

		// call the frame to refresh
		// repaint();

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