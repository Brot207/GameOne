package GameObjects;

import java.util.List;

public class Level {
	
	private Snake snake;
	private List<Dot> otherParts = null;
	
	private int pHEIGHT;
	private int pWIDTH;
	
	private int startX;
	private int startY;
	private int DELAY;
	private int fasterDELAY;
	private boolean customConfig = false;
	
	
	private String name;
	private int lvlID;
	
	public Level(Snake snake, List<Dot> parts){
		this.snake = snake;
		this.otherParts = parts;
		
		pHEIGHT = 600;
		pWIDTH = 800;
		
		startX = 100;
		startY = 100;
		DELAY = 100;
		fasterDELAY = 200;
		
		name = "unnamed Level";
		lvlID = 0;
	}

	/**
	 * @return the snake
	 */
	public Snake getSnake() {
		return snake;
	}

	/**
	 * @return the otherParts
	 */
	public List<Dot> getOtherParts() {
		return otherParts;
	}
	
	/**
	 * @return false if lvl is std, false if true
	 */
	public boolean isCustom(){
		return customConfig;
	}
	
	/**
	 * @return the pHEIGHT
	 */
	public int getpHEIGHT() {
		return pHEIGHT;
	}


	/**
	 * @return the pWIDTH
	 */
	public int getpWIDTH() {
		return pWIDTH;
	}

	/**
	 * @return the startX
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * @return the startY
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * @return the dELAY
	 */
	public int getDELAY() {
		return DELAY;
	}

	/**
	 * @return the fasterDELAY
	 */
	public int getFasterDELAY() {
		return fasterDELAY;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the lvlID
	 */
	public int getLvlID() {
		return lvlID;
	}

	/**
	 * @param lvlID the lvlID to set
	 */
	public void setLvlID(int lvlID) {
		this.lvlID = lvlID;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param fasterDELAY the fasterDELAY to set
	 */
	public void setFasterDELAY(int fasterDELAY) {
		this.fasterDELAY = fasterDELAY;
		this.customConfig = true;
	}

	/**
	 * @param dELAY the dELAY to set
	 */
	public void setDELAY(int dELAY) {
		DELAY = dELAY;
		this.customConfig = true;
	}
	
	/**
	 * @param startY the startY to set
	 */
	public void setStartXY(int startX, int startY) {
		this.startX = startX;
		this.startY = startY;
		this.customConfig = true;
	}
	
	/**
	 * @param pWIDTH the pWIDTH to set
	 */
	public void setpW_pH(int pWIDTH, int pHEIGHT) {
		this.pHEIGHT = pHEIGHT;
		this.pWIDTH = pWIDTH;
		this.customConfig = true;
	}
	
	/**
	 * @param snake the snake to set
	 */
	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	/**
	 * @param otherParts the otherParts to set
	 */
	public void setOtherParts(List<Dot> otherParts) {
		this.otherParts = otherParts;
	}
}
