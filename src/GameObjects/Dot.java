package GameObjects;

import javax.swing.ImageIcon;

/**
 * This is one part of the snake.
 * @author stang
 *
 */
public class Dot extends ImageIcon {
	
	ImageIcon icon = null;
	DotTyp typ = null;
	
	private int locX;
	private int locY;
	
	/**
	 * Sets the part Image and the parts location on the panel given by x and y coordinates. 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Dot(int x, int y){
		this.setImage(new ImageIcon("src/Icons/dot.gif").getImage()); 
		locX = x;
		locY = y;
	}
	
	/**
	 * creates a part given by the part type (head or body part) and sets its location on the panel given by x and y coordinates. 
	 * @param p the part type
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Dot(DotTyp p, int x, int y){
		if(p == DotTyp.HEAD){
			this.setImage(new ImageIcon("src/Icons/head.gif").getImage());
		}else{
			this.setImage(new ImageIcon("src/Icons/dot.gif").getImage());
		}
		
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
	public DotTyp getTyp() {
		return typ;
	}

}