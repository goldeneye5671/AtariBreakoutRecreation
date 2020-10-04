package AtariBreakout; 

import java.awt.Color;
import java.awt.Graphics;

public class brick {
	static int NumbBricks = 0;
	int type;
	int pointVal;
	String color;
	int xtl, ytl;
	int xtl2, ytl2;
	int xtr, ytr;
	int xbl, ybl;
	int xbr, ybr;
	int length, width;
	boolean hit;
	
	public brick(int xpos, int ypos, int l, int w, int t) {
		xtl = xpos; ytl = ypos;
		xtl2 = xpos; ytl2 = ypos;
		length = l; width = w;
		type = t; NumbBricks = 33;
		hit = false;
		switch (type) {
		case 1:
			color = "red";
			pointVal = 10;
			break;
				
		case 2:
			color = "orange";
			pointVal = 20;
			break;
		case 3: 
			color = "yellow";
			pointVal = 30;
			break;
		case 4:
			color = "green";
			pointVal = 40;
			break;
		case 5:
			color = "magenta";
			pointVal = 50;
			break;
		case 6: 
			color = "gray";
			pointVal = 60;
			break;
		case 7: 
			color = "darkGray";
			pointVal = 70;
			break;
		default:
			color = "#ERR";
			pointVal = 0;
			break;
	}
	}
	
	public void setMe() {
		xtr = xtl + length; ytr = ytl;
		xbl = xtl; ybl = ytl + width;
		xbr = xtl + length; ybr = ytl + width;
	}
	
	public void drawMe(Graphics g) {
		if (hit == true) {
			xtl = -100; ytl = -100;
			tracker.addPoints(pointVal);
			NumbBricks--;
		}
		if (color.equalsIgnoreCase("red")) {
			g.setColor(Color.red);
		}else if (color.equalsIgnoreCase("orange")){
			g.setColor(Color.orange);
		}else if (color.equalsIgnoreCase("yellow")) {
			g.setColor(Color.yellow);
		}else if (color.equals("white")){
			g.setColor(Color.white);
		}else if (color.equals("gray")) {
			g.setColor(Color.gray);
		}else if (color.equals("darkGray")) {
			g.setColor(Color.darkGray);
		}else if (color.equals("magenta")) {
			g.setColor(Color.magenta);
		}else if (color.equals("green")) {
			g.setColor(new Color(0, 128, 0));
		}else {
			System.exit(0);
		}
		g.fillRect(xtl, ytl, length, width);
	}
	
	public void eraseMe(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(xtl, ytl, length, width);
	}
		
	public void setNumbBricks(int Amount) {
		NumbBricks = Amount;
	}
	
	public void resetMe() {
		xtl = xtl2; ytl = ytl2; setMe();
	}
}
