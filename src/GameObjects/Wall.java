package GameObjects;

import javax.swing.ImageIcon;

public class Wall extends Dot {

	ImageIcon icon = null;
	
	//constructor, Start position is not being used
	public Wall (int x, int y){
		super(DotTyp.WALL,x,y);
	}
	
	
	
	/*public int getLocX() {
		return locX;
	}
	
	public void setLocX(int locX) {
		this.locX = locX;
	}
	
	public int getLocY () {
		return locY;
	}
	
    public void setLocY (int locY) {
    	this.locY = locY;
    }
    
	public ImageIcon getIcon() {
		return icon;
	}*/
	
	
	
    
}