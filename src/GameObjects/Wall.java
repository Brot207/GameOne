package GameObjects;

import javax.swing.ImageIcon;

public class Wall extends ImageIcon {

	ImageIcon icon = null;
	
	private int locX;
	private int locY;
	private int wallLength;
	private boolean isHorizontal;
	
	//constructor: single wall
	public Wall (int x, int y){
		this.setImage(new ImageIcon("src/Icons/brickwall.jpg").getImage());
		locX = x;
		locY = y;
	}
	
	//constructor: wall with defined length and orientation
	public Wall (int x, int y, int length, boolean isHorizontal) {
		this.setImage(new ImageIcon("src/Icons/brickwall.jpg").getImage());
		locX = x;
		locY = y;
		this.wallLength = length;
		this.isHorizontal = isHorizontal;
	}
	
	public int getLocX() {
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
	}
	
	public int getWallLenght () {
		return wallLength;
	}
	
	public void setWallLength (int wallLength) {
		this.wallLength = wallLength;
	}
	
	public boolean getOrientation () {
		return this.isHorizontal;
	}
	
    
}
