package GameObjects;

import javax.swing.ImageIcon;

/**
 * The head of the snake
 * @author stang
 *
 */
public class HeadDot extends Dot{
	
	public HeadDot(int x, int y){
		super(DotTyp.HEAD, x, y);
	}
}
