package GameObjects;

import javax.swing.ImageIcon;

public class Part {
	
	ImageIcon icon = null;
	PartTyp typ = null;
	
	private int locX;
	private int locY;
	
	public Part(PartTyp p, int x, int y){
		if(p == PartTyp.HEAD){
			icon = new ImageIcon("head.png");
		}else{
			icon = new ImageIcon("dot.png");
		}
		
		locX = x;
		locY = y;
	}

	public Part(int x, int y){
		icon = new ImageIcon("dot.png");
		
		locX = x;
		locY = y;
	}
	
	/**
	 * @return the locX
	 */
	public int getLocX() {
		return locX;
	}

	/**
	 * @param locX the locX to set
	 */
	public void setLocX(int locX) {
		this.locX = locX;
	}

	/**
	 * @return the locY
	 */
	public int getLocY() {
		return locY;
	}

	/**
	 * @param locY the locY to set
	 */
	public void setLocY(int locY) {
		this.locY = locY;
	}

	/**
	 * @return the icon
	 */
	public ImageIcon getIcon() {
		return icon;
	}

	/**
	 * @return the typ
	 */
	public PartTyp getTyp() {
		return typ;
	}

}
