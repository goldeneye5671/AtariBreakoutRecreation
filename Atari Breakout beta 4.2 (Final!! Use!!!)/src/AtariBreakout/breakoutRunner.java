package AtariBreakout; 

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class breakoutRunner {
	
	static boolean launchBall = false;
	
	public void runOnePlayer(Graphics g, paddle p1, ball b1, collision c, wall wL, wall wR, wall wB, wall wT, tracker t, Timer t1, int keycode, int enterCount){
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		commandsForBricks(g, b1, mainApplet.choice, mainApplet.ArrayCol, mainApplet.ArrayRow, c, mainApplet.bricks1p, mainApplet.bricks2p);
		if (mainApplet.lose == false) {
			b1.moveMe();
			p1.move(keycode, wR.x1, false);
			p1.setMe();
			b1.setMe();
			c.detect(wT, b1);
			c.detect(wB, b1);
			c.detect(wL, b1);
			c.detect(wR, b1);
			c.detect(b1, p1);
			t.death(wB, t1, b1, g, this);
			wL.drawMe(g);
			wR.drawMe(g);
			wT.drawMe(g);
			wB.drawMe(g);
			b1.drawMe(g);
			p1.drawMe(g);
			g.drawString("Score: " + tracker.points, 200, 10);
			g.drawString("Lives: " + t.lives, 600, 10);
		}else {
			wL.drawMe(g);
			wR.drawMe(g);
			wT.drawMe(g);
			wB.drawMe(g);
			b1.drawMe(g);
			p1.drawMe(g);
			t.death(wB, t1, b1, g, this);
			g.drawString("Score: " + tracker.points, 200, 10);
			g.drawString("Lives: " + t.lives, 600, 10);
		}
	}
	
	public void runTwoPlayer(Graphics g, paddle p1, paddle p2,  ball b1, collision c, wall wL, wall wR, wall wB, wall wT, tracker t, Timer t1, int keycode, int enterCount) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 400);
		commandsForBricks(g, b1, mainApplet.choice, mainApplet.ArrayCol, mainApplet.ArrayRow, c, mainApplet.bricks1p, mainApplet.bricks2p);
		p1.move(keycode, wR.x1, true);
		p2.move(keycode, wR.x1, true);
		b1.moveMe();
		p1.setMe();
		p2.setMe();
		b1.setMe();
		c.detect(wT, b1);
		c.detect(wB, b1);
		c.detect(wL, b1);
		c.detect(wR, b1);
		c.detect(b1, p1);
		c.detect(b1, p2);
		t.death(wB, t1, b1, g, this);
		wL.drawMe(g);
		wR.drawMe(g);
		wT.drawMe(g);
		wB.drawMe(g);
		b1.drawMe(g);
		p1.drawMe(g);
		p2.drawMe(g);
		g.drawString("Score 1: " + tracker.points, 200, 10);
		g.drawString("Score 2: " + tracker.points2, 350, 10);
		g.drawString("Lives 1: " + t.lives, 550, 10);
		g.drawString("Lives 2: " + t.lives2, 650, 10);
	}
	
	//spawns the bricks in the array, both the one and two player array.
		public void makeBricks(int xSpawnBrick, int ySpawnBrick, int ArrayCol, int ArrayRow, int type, brick bricks1p[][], brick bricks2p[][]) {
			//iterates through the rows. happens after the inner loop completes
			for (int i = 0; i < ArrayRow; i++) {
				//iterates through the columns. Happens until condition is met
				for (int j = 0; j < ArrayCol; j++) {
					//creates a new brick and then moves the x position over for the next brick to spawn.
					bricks1p[i][j] = new brick(xSpawnBrick, ySpawnBrick, 60, 15, type);
					xSpawnBrick = xSpawnBrick+63;
				}
				//updates the y position for the next row
				ySpawnBrick += 20;
				//resets the x value to 40.
				xSpawnBrick = 40;	
				type--;
			}
			//resets the spawn and brick type and repeats the process for the two player array.
			ySpawnBrick = 100;
			xSpawnBrick = 40;
			type = 7;
			for (int i = 0; i < ArrayRow; i++) {
				for (int j = 0; j < ArrayCol; j++) {
					bricks2p[i][j] = new brick(xSpawnBrick, ySpawnBrick, 60, 15, type);
					xSpawnBrick += 63;
				}
				ySpawnBrick += 20;
				xSpawnBrick = 40;	
				type--;
			}
		}
		
		public void commandsForBricks(Graphics g, ball b1, int choice, int ArrayCol, int ArrayRow, collision c, brick bricks1p[][], brick bricks2p[][]) {
			//specificly calls the methods for every brick in the array for setting, checking collision, and drawing the bricks.
			//called at each repaint.
			
			//depends on the choice variable. if it's zero, it will use the ip array of bricks. if it's one, it uses the 2p array.
			if (choice == 0) {
				//updates the row location
				for (int i = 0; i < ArrayRow; i++) {
					//updates the column location
					for (int j = 0; j < ArrayCol; j++) {
						//sets the new brick location, checks colision, and draws the result
						bricks1p[i][j].setMe();
						c.detect(b1, bricks1p[i][j]);
						bricks1p[i][j].drawMe(g);
					}
				}
				//similar process for 2 player
			}else if (choice == 1) {
				for (int i = 0; i < ArrayRow; i++) {
					for (int j = 0; j < ArrayCol; j++) {
						bricks2p[i][j].setMe();
						c.detect(b1, bricks2p[i][j]);
						bricks2p[i][j].drawMe(g);
					}
				}
			}
		}

		
}
