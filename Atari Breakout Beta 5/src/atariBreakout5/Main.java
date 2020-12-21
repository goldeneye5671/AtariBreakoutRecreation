package atariBreakout5;

import javax.swing.JFrame;

public class Main extends JFrame{

	private String title = "Extending Dogs!";
	private int width = 1100;
	private int height = 960;
	
	public Main() {
		super.setTitle(title);
		super.setSize(width, height);
		super.setLocation(200, 200);
		super.setResizable(false);
		super.add(new contents());
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public static void main (String [] args) {
		new Main();
	}	
}
