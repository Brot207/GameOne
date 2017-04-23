package GameObjects;


import javax.swing.ImageIcon;

public enum DotTyp {
	HEAD,
	BODYPART,
	APPLE, 
	BULLET,
	WALL,
	STAR;
	
	
	public ImageIcon getImageIcon(){		
		switch(this){
			case HEAD:
				return new ImageIcon("src/Icons/head.gif");
			case BODYPART:
				return new ImageIcon("src/Icons/dot.gif");
			case APPLE:
				return new ImageIcon("src/Icons/dot.gif");
			case BULLET:
				return new ImageIcon("src/Icons/dot.gif");
			case WALL:
				return new ImageIcon("src/Icons/brickwall.jpg");
			case STAR:
				return new ImageIcon("src/Icons/star.png");
			default:
				return new ImageIcon("src/Icons/dot.gif");	
		}
		
	}
	
}
