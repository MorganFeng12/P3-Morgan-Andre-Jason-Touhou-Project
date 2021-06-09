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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	// handles drawing animation
	Timer animationTimer;
	Background d;
	Background i;
	Background forest;
	Character c;
	Font verdana = new Font("Verdana", Font.BOLD, 80);
	Font verdana1 = new Font("Verdana", Font.BOLD, 50);
	Font verdana2 = new Font("Verdana", Font.BOLD, 35);
	private int count = 0;
	private int boss = 0;
	Heart h1, h2, h3;
	Music m1;
	int score = 0;
	Enemy[] enemies = new Enemy[10];
	
	Enemy e;
	Ball b;
	Ball2[] obj;
	Ball3[] obj2; 
	Ball4[] obj3;

	public void paint(Graphics g) {
		super.paintComponent(g);

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


		animationTimer.start();

		// instantiate the rest of the instance variables
		d = new Background("desert1.gif");

		i = new Background("ice1.gif");

		forest = new Background("Forest.gif");

		c = new Character("naruto.png");
		//s = new Sasuke("Sasuke.png");
		d = new Background("desert1.gif");
		m1 = new Music("Naruto1.wav", true);
		m1.play();


	}

	
	// stuff for collision
	public void update() {
		// calls collide
		for (int i = 0; i < obj.length; i++) {
			b.collide(obj[i]);
		}

		for (int i = 0; i < obj2.length; i++) {
			b.collide(obj2[i]);
		}

		for (int i = 0; i < obj3.length; i++) {
			b.collide(obj3[i]);
		}

	}

	/* this method is invoked/called by the timer */
	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println(arg0.getKeyCode());

		switch (arg0.getKeyCode()) {
		case 87:

			break;
		case 83:
			b.moveDown();
			// System.out.println("case 83");
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
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		// System.out.println("clicked");

		Rectangle bR = new Rectangle(220, 365, 360, 150);
		Rectangle mR = new Rectangle(m.getX(), m.getY(), 200, 140);

		if (bR.intersects(mR)) {
			count++;
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
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

}