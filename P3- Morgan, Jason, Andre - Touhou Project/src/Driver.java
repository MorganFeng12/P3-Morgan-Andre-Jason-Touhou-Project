import java.awt.Color;
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

	Character c;
	Sasuke s;
	Sasuke s2;
	Music m1;
	int score = 0;
	Enemy[] enemies = new Enemy[20];

	int cntr = 0;

	Bullets b;

	public void paint(Graphics g) {
		super.paintComponent(g);


		d.paint(g);
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].paint(g);
		}

		s.paint(g);

		b.paint(g);

		for (int i = 0; i < enemies.length; i++) {

			if (b.collide(enemies[i])) {
				cntr++;
				System.out.println("Hi");

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

		b.update(sX+150,sY+60);

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



		// setup animation timer
		animationTimer = new Timer(16, this);

		animationTimer.start();

		// instantiate the rest of the instance variables

		s = new Sasuke("Sasuke.png");
		d = new Desert("desert1.gif");
		m1 = new Music("Touhou1.wav", true);
		b = new Bullets("Fireball.png");
		m1.play();


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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}