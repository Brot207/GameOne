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
				return new ImageIcon(System.getProperty("user.dir") + "/head.gif");
			case BODYPART:
				return new ImageIcon(System.getProperty("user.dir") + "/dot.gif");
			case APPLE:
				return new ImageIcon(System.getProperty("user.dir") + "/dot.gif");
			case BULLET:
				return new ImageIcon(System.getProperty("user.dir") + "/dot.gif");
			case WALL:
				return new ImageIcon(System.getProperty("user.dir") + "/brickwall.jpg");
			case STAR:
				return new ImageIcon(System.getProperty("user.dir") + "/star.png");
			default:
				return new ImageIcon(System.getProperty("user.dir") + "/dot.gif");	
		}
		
	}
	
}
