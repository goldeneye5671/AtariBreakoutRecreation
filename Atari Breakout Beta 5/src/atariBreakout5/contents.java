package atariBreakout5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


/*
 * keycodes:
 * 		37	left
 * 		38	up
 * 		39	right
 * 		40	down
 */

public class contents extends JPanel implements ActionListener, KeyListener {
	static int ArrayCol = 11; //1;
    static int ArrayRow = 7; //1;
    int delay = 15;
    static int choice = 0;
    int keycode = 0;
    int enterCount = 0;
    //for the mackBricks Method
    int xSpawnBrick = 40;
    int ySpawnBrick = 45;
    int type = 7; 
    int resetcounter = 0;
    
    static brick [][] bricks1p = new brick[ArrayRow][ArrayCol];
    static brick [][] bricks2p = new brick[ArrayRow][ArrayCol];
    
    static boolean launch = false;
    static boolean reset = false;
    static boolean lose = false;
    
    paddle p1 = new paddle(400, 350, 110, 15, 1);
    paddle p2 = new paddle(400, 10, 90, 15, 2);
    
    ball b1 = new ball(400, p1.ytl-100, 0, 0, 10);
    
    wall wL = new wall(0, 0, 0, 400, "L");
    wall wR = new wall(800, 0, 800, 400, "R");
    wall wT = new wall(0, 0, 750, 0, "T");
    wall wB = new wall(0, 400, 800, 400, "B");
    
    collision c = new collision();
    
    Timer t = new Timer(delay, this);
    
    tracker trac = new tracker();
    
    mainMenu s = new mainMenu();
    
    breakoutRunner br = new breakoutRunner();
	public contents() {
		super.setDoubleBuffered(true);
		addKeyListener(this);
	    setFocusable(true);
		t = new Timer(delay, this);
		trac.storage.add(new player(0, null));
        br.makeBricks(xSpawnBrick, ySpawnBrick, ArrayCol, ArrayRow, type, bricks1p, bricks2p);
        launch = false;
        br.launchBall = false;
        addKeyListener(this);
        setFocusable(true);
        tracker.points = 0;
        trac.lives = 3;
        trac.lives2 = 3;
        trac.level = 1;
          brick.NumbBricks = ArrayCol*ArrayRow;
		t.start();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 //rewrite this in the start class, call it public void informUser();
        if (launch == true) {
            if (choice == 0) {
                br.runOnePlayer(g, p1, b1, c, wL, wR, wB, wT, trac, t, keycode, enterCount);
                if (lose == false) {
                    if (br.launchBall) {
                        if (c.bottom == true) {
                            br.launchBall = false;
                            b1.xvel = 0; b1.yvel = 0;
                            b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                        }
                    }
                }else {
                    b1.xvel = 0; b1.yvel = 0;
                    b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                }
            }else if (choice == 1) {
                br.runTwoPlayer(g, p1, p2, b1, c, wL, wR, wB, wT, trac, t, keycode, enterCount);
                if (lose == false) {
                    if (br.launchBall) {
                        if (c.bottom == true) {
                            br.launchBall = false;
                            b1.xvel = 0; b1.yvel = 0;
                            b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                        }else if (c.top == true){
                            br.launchBall = false;
                            b1.xvel = 0; b1.yvel = 0;
                            b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                        }
                    }
                }else {
                    b1.xvel = 0; b1.yvel = 0;
                    b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                }
            }
        }else if(launch == false) {
            g.setColor(Color.green);
            g.drawString("High score: " + trac.search().score, 400, 400);
            s.load(g, choice);
        }
		
	}
	
	public void checkDirection() {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keycode = e.getKeyCode();
        if (launch == false) {
            if (keycode == 40) {
                choice = 1;
                repaint();
            }else if(keycode == 38) {
                choice = 0;
                repaint();
            }else if(keycode == 10) {
                launch = true;
                trac.playerCount = choice;
                trac.ask();
                repaint();
            }else {
                keycode = 0;
            }
        }else if (launch == true) {
            if (choice == 0) {
                if (lose == false) {
                    if (br.launchBall == false) {
                        b1.xvel = 0; b1.yvel = 0;
                        b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                    
                        if (keycode == 10) {
                            br.launchBall = true;
                            b1.xvel = 3; b1.yvel = 3;
                        }
                    }else { }
                }else {
                    b1.xvel = 0; b1.yvel = 0;
                    b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                    reset();
                }
            }else {
                if (choice == 1) {
                    if (lose == false) {
                        if (br.launchBall == false) {
                            b1.xvel = 0; b1.yvel = 0;
                            b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                    
                            if (keycode == 10) {
                                br.launchBall = true;
                                b1.xvel = 3; b1.yvel = 3;
                            }
                            
                        }else {
                            
                        }
                    }else {
                        b1.xvel = 0; b1.yvel = 0;
                        b1.xtl = p1.xtl; b1.ytl = p1.ytl - 100;
                        reset();
                    }
                }
            }
        }
	}

	public void setFalse() {
        br.launchBall = false;
    }
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		keycode = 0;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	
	public void callMe(){
        b1.xtl = p1. xtl;
        b1.ytl = p1.ytl - 100;
    }
	 public static void reset() {
         for (int i = 0; i < ArrayRow; i++) {
             for (int j = 0; j < ArrayCol; j++) {
                 bricks1p[i][j].resetMe();
             }
         }
         for (int i = 0; i < ArrayRow; i++) {
             for (int j = 0; j < ArrayCol; j++) {
                 bricks2p[i][j].resetMe();
             }
         }
         reset = false;
         lose = false;
         breakoutRunner.launchBall = false;
         brick.NumbBricks = ArrayCol*ArrayRow;
         System.out.println(breakoutRunner.launchBall);
 }
}
