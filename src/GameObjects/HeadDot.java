package GameObjects;

import javax.swing.ImageIcon;

/**
 * The head of the snake
 * @author stang
 *
 */
public class HeadDot extends Dot{

	
	ImageIcon ball = new ImageIcon("head.png");
	
	public HeadDot(int x, int y){
		super(DotTyp.HEAD, x, y);
	}
}
