package atariBreakout5;
   

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class mainMenu {
	
	boolean startGame = false;
	int xv; int yv;
	int rad;
	int gameType;
	
	public void choiceOutOfBounds(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(200, 200, 30, 30);
		g.drawOval(200, 250, 30, 30);
	}
	
	public void choiceIsZero(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(200, 230, 15, 15);
		g.fillOval(240, 200, 15, 15);
	}
	
	public void choiceIsOne(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(200, 200, 15, 15);
		g.fillOval(240, 240, 15, 15);
	}
	
	public void load(Graphics g, int choice) {
		contents.lose = false;
		if (choice == 1) {
			choiceIsOne(g);
		}else if(choice == 0) {
			choiceIsZero(g);
		}
	}
}
