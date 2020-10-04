package AtariBreakout; 

import java.awt.*;

public class ball {
	int xtl = 0; int ytl = 0;
	int cx, cy;
	int tx, ty;
	int bx, by;
	int lx, ly;
	int rx, ry;
	//these are the velocity variables
	int xvel, yvel;
	//and this is the radius
	int radius;
	int diamater;
	
	//default constructor
	public ball() {
		xtl = 100; ytl = 100;
		xvel = 1; yvel = 1;
		radius = 10;
		diamater = 2*radius;
	}
	
	//user-defined constructor
	public ball(int x, int y, int xv, int yv, int r) {
		xtl = x; ytl = y;
		xvel = xv; yvel = yv;
		radius = r;
		diamater = 2*radius;
	}
	
	public void setMe() {
		cx = xtl + radius; cy = ytl + radius;
		tx = cx; ty = cy - radius;
		bx = cx; by = cy + radius;
		lx = cx - radius; ly = cy;
		rx = cx + radius; ry = cy;
	}
	
	public void drawMe(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(xtl, ytl, diamater, diamater);
	}
	
	public void eraseMe(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(xtl, ytl, radius*2, radius*2);
	}
	
	public void moveMe() {
		xtl += xvel; 	ytl += yvel;
	}
}
