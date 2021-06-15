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
	Sasuke s;
	Music m1, m2;
	int score = 0;
	int end = 0;
	int lives = 20;
	int bosslives = 6;
	int bosslives2 = 6;
	int mouseclicked = 0;
	Enemy[] enemies = new Enemy[10];
	Enemy[] enemies2 = new Enemy[10];
	BossBullets[] naruto = new BossBullets[3];
	BossBullets[] zab = new BossBullets[3];
	Enemy[] bats = new Enemy[7];
	int[] eX = new int[7];
	int[] eY = new int[7];
	Boss boss1;
	Boss boss2;
	int cntr = 0;
	Bullets b;
	EnemyBullets[] bull = new EnemyBullets[7];
	EnemyBullets[] bull2 = new EnemyBullets[7];
	Enemy[] bats2 = new Enemy[7];
	int[] eX2 = new int[7];
	int[] eY2 = new int[7];

	public void paint(Graphics g) {
		super.paintComponent(g);

		//loading in the background 
		if (boss == 0) {
			d.paint(g);
		} else {
			i.paint(g);
		}

		//launching the loading screen
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
		//first wave of enemies and bosses
		if (count == 1) {
			//spawning in the 10 non-shooting enemies  and sensing if the players bullets collide
			//if there is collision, the enemies are teleported off and the score increases
			for (int i = 0; i < enemies.length; i++) {
				enemies[i].paint(g);

				if (b.collide(enemies[i])) {

					enemies[i].setX(-5000);
					enemies[i].setY((int) (Math.random() * 10000));
					score++;
				}

			}
			//putting the lives and score system onto the screen
			g.setFont(verdana2);
			g.setColor(Color.black);
			g.drawString("Lives: " + lives, 15, 45);
			g.drawString("Score: " + score, 300, 45);

			s.paint(g);

			b.paint(g);
			
			//painting the shooting enemies, which also includes the collision mechanism, where if the 
			//players bullet collides with the enemy, they are teleported off and the score increases
			//also, if the shooting enemies bullet hits the player, the player loses a life
			
			for (int i = 0; i < 7; i++) {
				bats[i].paint(g);
				bull[i].paint(g);
				if (bull[i].collide(s)) {
					lives--;
					bull[i].setY(2000);
					bull[i].setX(6000);
				}
				if (b.collide(bats[i])) {
					bats[i].setY(-5000);
					score++;
				}
				eX[i] = bats[i].getX();
				eY[i] = bats[i].getY();
				bull[i].update(eX[i], eY[i]);
			}

			b.paint(g);

			int sX = s.getX();
			int sY = s.getY();
			b.update(sX + 150, sY + 60);
			int sX1 = s.getX();
			int sY1 = s.getY();
			b.update(sX1 + 150, sY1 + 60);

			//once the first wave is done, this part spawns in the boss
			if (score == 17) {
				boss1.paint(g);
				int nX = boss1.getX();
				int nY = boss1.getY();
				//detects the boss's bullets collision with the player
				for (int i = 0; i < naruto.length; i++) {
					naruto[i].update(nX, nY);
					naruto[i].paint(g);
					if (naruto[i].collide(s)) {
						lives--;
						naruto[i].setX(-5000);

					}
				}
				//if player bullets collides with the boss, it removes a bosslive, and since the boss has 6 lives
				//once its lives are 0, it will be teleported off the screen and the score increases by 10
				if (b.collide(boss1)) {
					b.setX(2000);
					b.setY(-2000);
					bosslives--;
					if (bosslives == 0) {
						boss1.setX(5000);
						boss1.setY(-2000);
						score += 10;
					}
				}

			}
			
			//once boss killed, the new background is loaded in as well the 7 new shooting enemies
			if (score >= 27) {
				boss++;
				for (int i = 0; i < 7; i++) {
					bats2[i].paint(g);
					bull2[i].paint(g);
					eX2[i] = bats2[i].getX();
					eY2[i] = bats2[i].getY();
					bull2[i].update(eX2[i], eY2[i]);
				}
				//collision with the player, if it hits, lives goes down 1 and the bullet is teleported
				for (int i = 0; i < bull2.length; i++) {
					if (bull2[i].collide(s)) {
						lives--;
						bull2[i].setX(-5000);
					}
				}
				//if the players bullets hits the bat, the score goes up and the bat is teleported off
				for (int i = 0; i < bats2.length; i++) {
					if (b.collide(bats2[i])) {
						score++;
						b.setX(5000);
						bats2[i].setX(-50000);
						bats2[i].setY(50000);

					}
				}

			}
			//once the second wave of small enemies is over, the second boss spawns
			if (score > 33) {
				boss2.paint(g);
				int nX1 = boss2.getX();
				//boss bullets collision with player
				int nY1 = boss2.getY();
				for (int i = 0; i < zab.length; i++) {
					zab[i].update(nX1, nY1);
					zab[i].paint(g);
					if (zab[i].collide(s)) {
						lives--;
						zab[i].setX(-5000);

					}
				//player bullets collision with boss
					if (b.collide(boss2)) {
						b.setX(2000);
						b.setY(-2000);
						bosslives2--;
						if (bosslives2 == 0) {
							boss2.setX(10000);
							boss2.setY(-3000);
							score += 10;
						}
					}

				}
			}
			//44 is the max score, so if it is reached, the player has beat the game and the end screen pops up
			if (score >= 44) {
				count++;

			}

			//if the player has 0 lives, it has died, and the game is also over
			if (lives <= 0) {
				count++;

			}

		}
		if (count == 2) {
			//if the player died, it prints a try again sign
			if (lives == 0) {
				g.setColor(Color.orange);
				g.fillRect(70, 130, 650, 300);
				g.setFont(verdana);
				g.setColor(Color.black);
				g.drawString("Game Over", 142, 250);
				g.setFont(verdana1);
				g.drawString("Try Again Next Time!", 100, 350);
			} 
			//if the player didn't die, they beat the game and a congratulations sign pops up
			else {
				g.setColor(Color.orange);
				g.fillRect(70, 130, 650, 300);
				g.setFont(verdana);
				g.setColor(Color.black);
				g.drawString("Game Over", 142, 250);
				g.drawString("Good Job!", 168, 350);

			}
		}
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


		animationTimer.start();

		// instantiate the rest of the instance variables
		s = new Sasuke("Sasuke.png");
		b = new Bullets("Fireball.png");

		i = new Background("ice1.gif");
		forest = new Background("Forest.gif");
		d = new Desert("desert1.gif");

		m1 = new Music("Naruto1.wav", true);
		m1.play();

		//loops for all of teh arrays instantiating them as their specific png or gif
		for (int i = 0; i < 7; i++) {
			bats[i] = new Enemy("Bat6.png");
		}

		for (int b = 0; b < 3; b++) {
			naruto[b] = new BossBullets("Fireball.png");
		}

		for (int c = 0; c < 3; c++) {
			zab[c] = new BossBullets("Fireball.png");
		}
		for (int i = 0; i < bats2.length; i++) {
			bats2[i] = new Enemy("Bat6.png");
		}

		for (int i = 0; i < bull2.length; i++) {
			bull2[i] = new EnemyBullets("Fireball.png");
		}

		for (int k = 0; k < 7; k++) {
			bull[k] = new EnemyBullets("Fireball.png");
		}

		boss1 = new Boss("naruto.png");
		boss2 = new Boss("Zabuza4.png");

		for (int i = 0; i < enemies.length; i++) {
			enemies[i] = new Enemy("Bat6.png");

		}
		for (int j = 0; j < enemies2.length; j++) {
			enemies2[j] = new Enemy("Bat6.png");
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
		//is w or s is pressed on the keyboard, the player moves up/down respectively
		switch (arg0.getKeyCode()) {
		case 87:
			b.moveUp();

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
		//checks if the user has pressed the start button, and if they have, launches up the game
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

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}