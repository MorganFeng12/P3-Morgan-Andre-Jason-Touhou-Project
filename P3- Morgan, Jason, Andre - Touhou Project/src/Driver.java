import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener{
	//handles drawing animation
	Timer animationTimer; 
	Ball b;
	
	//int x = 0;
	
	
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
		
		//setup animation timer
		animationTimer = new Timer(16, this);
		animationTimer.start();
		
		//instantiate the rest of the instance variables
		b = new Ball();
		
		f.setVisible(true);
		
	}

	/* this method is invoked/called by the timer*/ 
	@Override
	public void actionPerformed(ActionEvent e) {
		//call the frame to refresh
		repaint();
	}

}
