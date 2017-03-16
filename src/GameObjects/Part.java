package GameObjects;

import javax.swing.ImageIcon;

public class Part extends ImageIcon {
	
	ImageIcon icon = null;
	PartTyp typ = null;
	
	private int locX;
	private int locY;
	

	public Part(int x, int y){
		this.setImage(new ImageIcon("src/Icons/dot.gif").getImage()); 
		locX = x;
		locY = y;
	}
	
	
	public Part(PartTyp p, int x, int y){
		if(p == PartTyp.HEAD){
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
	public PartTyp getTyp() {
		return typ;
	}

}
