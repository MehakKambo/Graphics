import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

public class MovingObject extends JFrame{


	static int screenWidth = 800;
	static int screenHeight = 600;
	Random rand = new Random();  

	static int x1, x2; 
	static int y1, y2; 
	static int size1, size2; 
	static int speedX1, speedX2;
	static int speedY1, speedY2;

	public MovingObject() {  // initial setting
		super("Moving Object (Collision Detection)");
		setBounds(0, 0, screenWidth, screenHeight);  
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} 

	public static void main(String[] args) {
		setInitialValue();
		new MovingObject();
	}

	public void paint(Graphics g) {   
		updateCoordinate();
		myDrawing1(g);
		try{
			Thread.sleep(30); 
		} catch (Exception exc){}
		repaint();
	}

	public static void setInitialValue() {

		x1 = 30;
		y1 = 30;	
		size1 = 70;
		speedX1 = 8;
		speedY1 = 5;	

		x2 = 23;
		y2 = 36;	
		size2 = 30;
		speedX2 = 12;
		speedY2 = 7;
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


	public void myDrawing1(Graphics g){ 
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, screenWidth, screenHeight);

		g.setColor(Color.BLUE);
		// draw Ball1
		g.fillOval(x1, y1, size1,size1); 

		g.setColor(Color.BLACK);
		// draw Ball2
		g.fillOval(x2, y2, size2,size2); 

	}
}
