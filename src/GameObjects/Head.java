package GameObjects;

import javax.swing.ImageIcon;

public class Head extends Part{

	
	ImageIcon ball = new ImageIcon("head.png");
	
	public Head(int x, int y){
		super(PartTyp.HEAD, x, y);
	}
}
