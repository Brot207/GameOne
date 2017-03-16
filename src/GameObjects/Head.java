package GameObjects;

import javax.swing.ImageIcon;

/**
 * The head of the snake
 * @author stang
 *
 */
public class Head extends Part{

	
	ImageIcon ball = new ImageIcon("head.png");
	
	public Head(int x, int y){
		super(PartTyp.HEAD, x, y);
	}
}
