import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

public class MovingObject2 extends JFrame{


	static int screenWidth = 800;
	static int screenHeight = 600;
	static Random rand = new Random();  

	static int x1, x2; 
	static int y1, y2, a; 
	static int size1, size2; 
	static int speedX1, speedX2;
	static int speedY1, speedY2;
	static Color color1, color2;

	public MovingObject2() {  // initial setting
		super("Moving Object (Collision Detection)");
		setBounds(0, 0, screenWidth, screenHeight);  
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} 

	public void paint(Graphics g) {   

		updateCoordinate();

		g.setColor(Color.GREEN);
		g.fillRect(0, 0, screenWidth, screenHeight);

		myStar(g,x1,y1,size1, color1.RED);
		myStar(g,x2,y2,size2, color2.BLUE);

		try{
			Thread.sleep(30);  // 1000 = 1 second
		} catch (Exception exc){}

		repaint();
	}

	public static void setInitialValue() {

		// change these to random number
		x1 = rand.nextInt(screenWidth);
		y1 = rand.nextInt(screenHeight);	
		size1 = 45;
		speedX1 = 8;
		speedY1 = 5;	

		x2 = rand.nextInt(screenWidth);
		y2 = rand.nextInt(screenHeight);	
		size2 = 24;
		speedX2 = 12;
		speedY2 = 7;
	} 
	public void myStar(Graphics g, int x, int y, int size, Color starColor) {


		int [] xCoords = new int [10];
		int [] yCoords = new int [10];
		int ang = 90 - a;
		double rad;
		double PI = 3.14159;
		g.setColor(starColor);
		for (int i = 0; i< 10; i++) {
			if (i % 2 == 0)
				rad = size * 0.38;
			else rad = size;
			xCoords [i] += (int) (rad * Math.cos(PI * ang / 180.0));
			yCoords [i] -= (int) (rad * Math.sin(PI * ang / 180.0));
			ang +=36;
			xCoords [i] += x;
			yCoords [i] += y;
		}
		g.fillPolygon(xCoords, yCoords, 10);
	}


	public static void updateCoordinate() {

		if ((x1 + size1)> screenWidth || x1 < 0) {
			speedX1 *= -1;			
		}
		if ((y1 + size1) > screenHeight || y1 < 0) {
			speedY1 *= -1;
		}
		x1=x1+speedX1;
		y1=y1+speedY1;		

		if ((x2 + size2)> screenWidth || x2 < 0) {
			speedX2 *= -1;			
		}
		if ((y2 + size2) > screenHeight || y2 < 0) {
			speedY2 *= -1;
		}
		x2=x2+speedX2;
		y2=y2+speedY2;
	}


	public static void main(String[] args) {
		setInitialValue();
		new MovingObject2();
	}
}
