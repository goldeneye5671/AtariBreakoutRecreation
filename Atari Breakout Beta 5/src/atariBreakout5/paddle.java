package atariBreakout5;
   

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class paddle {
	int keycode = 0;
	int xtl, ytl;
	int xtr, ytr;
	int xbl, ybl;
	int xbr, ybr;
	int length, width;
	int playerNumber = 0;
	public paddle() {
		xtl = 25; ytl = 750;
		length = 30; width = 10;
	}
	
	public paddle(int xpos, int ypos, int l, int w, int playerNumb) {
		xtl = xpos; ytl = ypos;
		length = l; width = w;
		playerNumber = playerNumb;
	}
	
	public paddle(int xpos, int ypos, int l, int w) {
		xtl = xpos; ytl = ypos;
		length = l; width = w;
	}
	
	public void setMe() {
		xtr = xtl + length; ytr = ytl;
		xbl = xtl; ybl = ytl + width;
		xbr = xtl + length; ybr = ytl + width;
	}
	
	public void drawMe(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(xtl, ytl, length, width);
	}
	
	public void eraseMe(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(xtl, ytl, length, width);
	}
	
	public void move(int m, int wrx, boolean moreThanOnePlayer) {
		if (moreThanOnePlayer) {
			if (playerNumber == 1) {
				if (m == 37) {
					if (xtl < 0) {}else {moveLeft();}
				}else if (m == 39) {
					if (xtr > wrx) {}else {moveRight();}
				}
			}else if (playerNumber == 2) {
				if (m == 65) {
					if (xtl < 0) {}else {moveLeft();}
				}else if (m == 68) {
					if (xtr > wrx) {}else {moveRight();}
				}
			}
		}else if (!moreThanOnePlayer) {
			if (m == 37) {
				if (xtl < 0) {}else {moveLeft();}
			}else if (m == 39) {
				if (xtr > wrx) {}else {moveRight();}
			}	
		}
	}
	
	public void moveLeft() {
		xtl -= 6;
	}
	
	public void moveRight() {
		xtl += 6;
	}
}