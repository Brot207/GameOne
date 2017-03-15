package GameWindow;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private final int HEIGHT = 600;
	private final int WIDTH = 800;
	
	private final int dotSize = 10;
	private final int DELAY = 140;
	
	private final int ALLDOTS = (HEIGHT*WIDTH)/(dotSize*dotSize);
	private final int x[] = new int[ALLDOTS];
	private final int y[] = new int[ALLDOTS];
	
	
	public GamePanel(){
		
	}

}
