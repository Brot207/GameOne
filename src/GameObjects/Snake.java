package GameObjects;

import java.util.ArrayList;
import java.util.List;

import GameWindow.Direction;

public class Snake {
	
	private final int startLength = 3;
	private int length = startLength;
	private int dotSize = 10;
	
	private List<Part> parts = null;
	
	public Snake(){
		parts = new ArrayList<Part>();
		
		for(int x = 0; x < startLength; x++){
			if(x == 0){
				parts.add(new Head(50, 50));
				continue;
			}
			
			parts.add(new Part(50 - x*dotSize, 50));
		}
	}

	
	public void moveSnake(Direction d){
		for(int z = length-1; z > 0; z--){
			parts.get(z).setLocX(parts.get(z-1).getLocX());
			parts.get(z).setLocY(parts.get(z-1).getLocY());
		}
		
		if (d == Direction.LEFT) {
            parts.get(0).setLocX( parts.get(0).getLocX() - dotSize);
        }

        if (d == Direction.RIGHT) {
        	parts.get(0).setLocX( parts.get(0).getLocX() + dotSize);
        }

        if (d == Direction.UP) {
        	parts.get(0).setLocY( parts.get(0).getLocY() - dotSize);
        }

        if (d == Direction.DOWN) {
        	parts.get(0).setLocY( parts.get(0).getLocY() + dotSize);
        }
		
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
	public Part getPart_i(int i) {
		return parts.get(i);
	}

}
