package GameObjects;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Observable;

import GameObjects.DotTyp;

/**
 * This is one Dot
 * it is an Observable. This means an Observer can listen to its calls.
 *
 */
public class Dot extends Observable {
	
	private ImageIcon Image = null;
	DotTyp typ = null;
	
	protected boolean isAlive = true;
	
	private int locX;
	private int locY;
	
	/**
	 * Sets the part Image and the parts location on the panel given by x and y coordinates. 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Dot(int x, int y){
		this.typ = DotTyp.BODYPART;
		this.Image = this.typ.getImage();
		
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
		this.typ = p;
		this.Image = this.typ.getImage();
		
		locX = x;
		locY = y;
	}

	
	/**
	 * @param typ the typ to set
	 */
	public void setTyp(DotTyp typ) {
		this.typ = typ;
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
	public Image getImage() {
		return this.Image.getImage();
	}

	/**
	 * @return the typ
	 */
	public DotTyp getTyp() {
		return typ;
	}
	

	public boolean checkEvent(int tick){
		return false;
	}
	
	public void killDot(){
		this.isAlive = false;
		setChanged();				//shows that somethings has happend
		notifyObservers();			//calls all observers
	}
}
