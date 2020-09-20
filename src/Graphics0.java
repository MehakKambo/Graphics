import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame; 

public class Graphics0 extends JFrame {
	static int screenWidth = 800;
	static int screenHeight = 600;

	public Graphics0() {  
		super("Title");
		setBounds(0, 0, screenWidth, screenHeight);  
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} 

	public static void main(String[] args) { 
		new Graphics0();
	}
	public void paint(Graphics g) {   
		myDrawing1(g);
	}
	public void myDrawing1(Graphics g){ 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, screenWidth, screenHeight);
		g.setColor(Color.RED);
		g.fillRect(100, 100, 500, 300);

	}
}
