
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame; 
import java.util.*; 

public class Graphics1 extends JFrame {

	static int screenWidth = 800;
	static int screenHeight = 600;
	static Random rand= new Random();

	public Graphics1() {  // initial setting
		super("SO SATISFYING, RIGHT?");
		setBounds(0, 0, screenWidth, screenHeight);  
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) { 
		new Graphics1();
	}

	public void paint(Graphics g) {
		myDrawing1(g);
		try {
			Thread.sleep(3);}
		catch (Exception exc) {}
		repaint();
	}

	public void myDrawing1(Graphics g){ // your actual drawing 

		//ball color 
		int R = rand.nextInt(256);
		int G = rand.nextInt(256);
		int B = rand.nextInt(256);
		Color randomColor = new Color(R, G, B);
		g.setColor(randomColor);

		int x = rand.nextInt(800);
		int y = rand.nextInt(600);
		int w = rand.nextInt(46);
		g.fillRect(x, y, w, w);
	}
}