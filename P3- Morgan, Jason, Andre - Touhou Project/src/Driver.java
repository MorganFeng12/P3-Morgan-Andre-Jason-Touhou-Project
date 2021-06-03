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

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	//handles drawing animation
	Timer animationTimer; 
	Background d;
	Background i;
	Background forest;
	Ball b;
	Character c;
	Font verdana = new Font("Verdana", Font.BOLD, 80);
	Font verdana1 = new Font("Verdana", Font.BOLD, 50);
	private int count = 0;
	private int boss = 0;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//b.paint(g);
	  	
		//g.setColor(Color.blue);
		//g.fillOval(x, 0, 200, 200);
		//x += 2;
		
		if(boss == 0){
			d.paint(g);
		}
		
		if(boss == 1) {
			i.paint(g);
		}
		
		if(boss == 2) {
			forest.paint(g);
		}
		
		if(count == 0) {
			g.setFont(verdana);
			g.setColor(Color.blue);
			g.drawString("Touhou Project" , 55, 200);
			g.setFont(verdana1);
			g.setColor(Color.orange);
			g.fillRect(220, 335, 360, 100);
			g.setColor(Color.black);
			g.drawString("Start Game", 240, 400);	
		}
		
	}
	
	public Driver() {
		JFrame f = new JFrame("Touhou Project");
		f.setSize(800, 600); //width and height
		
		//set default action for x button
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//add this panel to the JFrame
		//allows connection with "drawing"
		f.add(this);
		
		//connect JFrame to keyboard listening code
		f.addKeyListener(this);
		
		//connect JFrame to mouse listening code
		f.addMouseListener(this);
		
		//connect JFrame to MouseMotionListener if necessary
		
		
		//setup animation timer
		animationTimer = new Timer(16, this);
		animationTimer.start();
		
		//instantiate the rest of the instance variables
		b = new Ball();
		
		d = new Background("desert1.gif");
		
		i = new Background("ice1.gif");
		
		forest = new Background("Forest.gif");
		
		f.setVisible(true);
		
	}

	/* this method is invoked/called by the timer*/ 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//call the frame to refresh
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.getKeyCode());
		if(arg0.getKeyCode() == 68) {
			b.moveRight();
		}

		switch(arg0.getKeyCode()) {
		//if keycode is 'd' key
		case 68:
			b.moveRight();
			break;
		
		case 65:
			System.out.println("stuff for left using a");
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		b.stop();  
		
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		//System.out.println("clicked");
		
		Rectangle bR = new Rectangle(220, 365, 360, 150);
		Rectangle mR = new Rectangle(m.getX(), m.getY(), 100, 100);
		
		if(bR.intersects(mR)) {
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
	
	//motion

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}
