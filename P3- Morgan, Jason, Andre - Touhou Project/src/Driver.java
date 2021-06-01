import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener{
	//handles drawing animation
	Timer animationTimer; 
	Ball b;
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		b.paint(g);
	  	
		//g.setColor(Color.blue);
		//g.fillOval(x, 0, 200, 200);
		//x += 2;
		
		
	}
	
	public Driver() {
		JFrame f = new JFrame("Example Drawing");
		f.setSize(800, 600); //width and height
		
		//set default action for x button
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//add this panel to the JFrame
		//allows connection with "drawing"
		f.add(this);
		f.addKeyListener(this);
		
		
		//setup animation timer
		animationTimer = new Timer(16, this);
		animationTimer.start();
		
		//instantiate the rest of the instance variables
		b = new Ball();
		
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
		b.moveRight();
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
