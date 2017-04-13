package GameObjects;

import java.awt.Image;

import javax.swing.ImageIcon;

public enum DotTyp {
	HEAD,
	BODYPART,
	APPLE, 
	BULLET,
	WALL;
	
	
	public Image getImage(){		
		switch(this){
			case HEAD:
				return new ImageIcon("src/Icons/head.gif").getImage();
			case BODYPART:
				return new ImageIcon("src/Icons/dot.gif").getImage();
			case APPLE:
				return new ImageIcon("src/Icons/dot.gif").getImage();
			case BULLET:
				return new ImageIcon("src/Icons/dot.gif").getImage();
			case WALL:
				return new ImageIcon("src/Icons/brickwall.jpg").getImage();
			default:
				return new ImageIcon("src/Icons/dot.gif").getImage();	
		}
		
	}
	
}
