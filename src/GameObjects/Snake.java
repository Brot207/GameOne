package GameObjects;

import java.util.ArrayList;
import java.util.List;

import GameWindow.Direction;

/**
 * This is the Snake
 * A Snake has several parts. (One head and multiple body parts)
 * @author stang
 *
 */
public class Snake {
	
	private final int startLength = 1;
	private int length = startLength;
	private int dotSize = 10;
	
	private int pWIDTH = 0;
	private int pHEIGHT = 0;
	
	
	private List<Dot> parts = null;
	private List<Dot> bullets = null;
	
	/**
	 * Creates a snake given by the default length
	 */
	public Snake(){
		parts = new ArrayList<Dot>();
		
		for(int x = 0; x < startLength; x++){
			if(x == 0){
				parts.add(new HeadDot(300, 300));
				continue;
			}
			
			parts.add(new Dot(300 - x*dotSize, 300));
		}
	}

	/**
	 * Creates a snake given by the default length at an starting point
	 */
	public Snake(int startPosition){
		parts = new ArrayList<Dot>();
		
		for(int x = 0; x < startLength; x++){
			if(x == 0){
				parts.add(new HeadDot(startPosition, startPosition));
				continue;
			}
			
			parts.add(new Dot(startPosition - x*dotSize, startPosition));
		}
	}
	
	
	/**
	 * moves the snake in the given direction.
	 * @param d the direction the snake is moving
	 */
	public void moveSnake(Direction d){
		for(int z = length-1; z > 0; z--){
			parts.get(z).setLocX(parts.get(z-1).getLocX());
			parts.get(z).setLocY(parts.get(z-1).getLocY());
		}
		
		if (d == Direction.LEFT) {
			if(parts.get(0).getLocX() <= 0) parts.get(0).setLocX(pWIDTH);
			else parts.get(0).setLocX( parts.get(0).getLocX() - dotSize);
            
        }

        if (d == Direction.RIGHT) {
        	if(parts.get(0).getLocX() >= pWIDTH) parts.get(0).setLocX(0);
        	else parts.get(0).setLocX( parts.get(0).getLocX() + dotSize);
        }

        if (d == Direction.UP) {
        	if(parts.get(0).getLocY() <= 0) parts.get(0).setLocY(pHEIGHT);
        	else parts.get(0).setLocY( parts.get(0).getLocY() - dotSize);
        }

        if (d == Direction.DOWN) {
        	if(parts.get(0).getLocY() >= pHEIGHT) parts.get(0).setLocY(0);
        	else parts.get(0).setLocY( parts.get(0).getLocY() + dotSize);
        }
		
	}
	
	/**
	 * adds one part to the snake and sets the new length
	 * @param d the dot that will be added to the snake
	 */
	public void expandSnake(Dot d){
		parts.add(d);
		this.length = parts.size();
		
	}
	
	
	public Dot getHead(){
		if(length > 0){
			return getPart_i(0);
		}
		
		return null;
	}
	
	public Dot getLastPart(){
		return this.parts.get(length-1);
	}
	
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the dotSize
	 */
	public int getDotSize() {
		return dotSize;
	}

	/**
	 * @param dotSize the dotSize to set
	 */
	public void setDotSize(int dotSize) {
		this.dotSize = dotSize;
	}

	/**
	 * @return the parts
	 */
	public Dot getPart_i(int i) {
		return parts.get(i);
	}
	
	
	/**
	 * @return the parts
	 */
	public List<Dot> getParts() {
		return parts;
	}

	/**
	 * @param pWIDTH the pWIDTH to set
	 */
	public void setpWIDTH(int pWIDTH) {
		this.pWIDTH = pWIDTH;
	}

	/**
	 * @param pHEIGHT the pHEIGHT to set
	 */
	public void setpHEIGHT(int pHEIGHT) {
		this.pHEIGHT = pHEIGHT;
	}

}
