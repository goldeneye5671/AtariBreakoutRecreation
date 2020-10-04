package AtariBreakout;  

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class tracker implements ActionListener{
    int lives = 3;
    int lives2 = 3;
    int playerCount = 0;
    int level;
    static int points;
    static int points2;
    int counter = 0;
    Timer timer1 = new Timer(1000, this);
    
    ArrayList <player> storage = new ArrayList(1);
    
    public void ask() {
        String n = null;
        if (playerCount == 0) {
            n = JOptionPane.showInputDialog("Please enter Player 1 name: ");
            storage.add(0, new player(0, n));
        }else if (playerCount == 1) {
            n = JOptionPane.showInputDialog("Please enter Player 1 name: ");
            storage.add(0, new player (0, n));
            JOptionPane.showInputDialog("Please enter Player 2 name: ");
            storage.add(0, new player (0, n));
        }
    }
    
    public player search() {
        int largest = 0;
        int arraynumber = 0;
        int where = 0;
        for (int i = 0; i < storage.size(); i++) {
            arraynumber = storage.get(i).score;
            if (arraynumber > largest) {
                largest = arraynumber;
                where = i;
            }
        }
        
        return storage.get(where);
    }
    
    public void updateLevel() {
        level++;
    }
    
    public void updateLives(int Li) {
        lives = Li;
    }
    
    public static void addPoints(int p) {
        points = points + p;
    }
    
    public void stopMr() {
        timer1.stop();
    }
    
    public void death(wall w, Timer t, ball b, Graphics g, breakoutRunner br) {
        if (playerCount == 0) {
            if (w.bottom) {
                lives --;
            }
            if (lives < 0) {
                storage.get(0).score = points;
                mainApplet.lose = true;
                g.drawString(storage.get(0).name + " has lost with a score of " + storage.get(0).score, 200, 200);
                timer1.start();
                br.launchBall = false;
            }else if (lives > 0){
               if (brick.NumbBricks <=0){
                   storage.get(0).score = points;
                mainApplet.lose = true;
                g.drawString(storage.get(0).name + " has won with a score of " + storage.get(0).score, 200, 200);
                timer1.start();
                br.launchBall = false;
                }
             }
        }else {
            if (w.bottom) {
                lives --;
            }
            if (w.top) {
                lives2 --;
            }
            storage.get(0).score = points2;
            storage.get(1).score = points;
            if (lives < 0) {
                mainApplet.lose = true;
                g.drawString(storage.get(1).name + " has lost with a score of " + storage.get(1).score, 0, 400);
                br.launchBall = false;
                timer1.start();
            }else if (lives2 < 0) {
                mainApplet.lose = true;
                g.drawString(storage.get(0).name + " has lost with a score of " + storage.get(0).score, 0, 400);
                br.launchBall = false;
                timer1.start();
            }
        }
    }
    
    public void actionPerformed(ActionEvent arg0) {
        counter++;
        mainApplet.lose = true;
        if (counter > 6) {
            lives = 3;
            lives2 = 3;
            counter = 0;
            points = 0;
            mainApplet.launch = false;
            stopMr();
        }
    }
}
