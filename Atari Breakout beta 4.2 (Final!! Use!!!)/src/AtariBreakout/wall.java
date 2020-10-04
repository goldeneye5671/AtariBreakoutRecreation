package AtariBreakout;  

import java.awt.*;

public class wall {
	boolean bottom = false;
	boolean top = false;
	//the (x1, y1) variables will be where the wall begins:
	int x1, y1;
	//the (x2, y2) variables will be where the wall ends:
	int x2, y2;
	//Lastly, there will be a string variable that will be used to determine how the collisions
	//will be detected: 'L' for left wall, 'R' for right wall, 'B' for bottom wall, and 'T'
	//for top wall:
	String side;
	
	//default constructor
	public wall() {
		x1 = 0; y1 = 0;
		x2 = 200; y2 = 200;
		side = "L";
	}
	
	//user-defined constructor
	public wall(int ux1, int uy1, int ux2, int uy2, String s) {
		x1 = ux1; y1 = uy1;
		x2 = ux2; y2 = uy2;
		side = s;
	}
	
	public void drawMe(Graphics g) {
		g.setColor(Color.white);
		g.drawLine(x1, y1, x2, y2);
	}
	//end of class
}