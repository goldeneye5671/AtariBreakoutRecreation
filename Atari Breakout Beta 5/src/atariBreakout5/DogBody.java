package atariBreakout5;

import java.awt.Color;
import java.awt.Graphics;

public class DogBody {
	int xtl = 0; int ytl = 0;
	int xtr = 0; int ytr = 0;
	int xbl = 0; int ybl = 0;
	int xbr = 0; int ybr = 0;
	int xvel = 0; int yvel = 0;
	int width = 100; int height = 0;
	
	public DogBody(int xtl, int ytl, int xvel, int yvel, int width, int height) {
		this.xtl = xtl;
		this.ytl = ytl;
		this.xvel = xvel;
		this.yvel = yvel;
		this.width = width;
		this.height = height;
	}
	
	public void changeXVel(int addToX) {
		xvel += addToX;
	}
	
	public void changeYVel(int addToY) {
		yvel += addToY;
	}
		
	public void moveMe() {
		xtl += xvel;
		ytl += yvel;
	}
	
	public void setMe() {
		xtr = xtl + width; ytr = ytl;
		xbl = xtl; ybl = ytl + height;
		xbr = xtl + width; ybr = ytl + height;
	}
	
	
	public void eraseMe(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(xtl, ytl, width, height);
	}
	
	public void drawMe(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(xtl, ytl, width, height);
	}
}
