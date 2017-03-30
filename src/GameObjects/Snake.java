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
	
	private final int startLength = 3;
	private int length = startLength;
	private int dotSize = 10;
	
	private int pWIDTH = 0;
	private int pHEIGHT = 0;
	
	private Direction headingDirection;
	
	
	private List<Dot> parts = null;
	private List<Bullet> bullets = null;
	
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
		this.headingDirection = d;
		for(int z = length-1; z > 0; z--){
			parts.get(z).setTyp(DotTyp.BODYPART);
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
	
	public void moveBullet(){
		if(this.bullets != null){
			for(int x = 0; x < this.bullets.size(); x++){
				Bullet b = this.bullets.get(x);
				Direction bulletDirection = b.getMovingDirection();
				if (bulletDirection == Direction.LEFT) {
					if(b.getLocX() <= 0) this.bullets.remove(b);
					else b.moveBullet();
		        }
		
		        if (bulletDirection == Direction.RIGHT) {
					if(b.getLocX() >= pWIDTH) this.bullets.remove(b);
					else b.moveBullet();
		        }
		
		        if (bulletDirection == Direction.UP) {
					if(b.getLocY() <= 0) this.bullets.remove(b);
					else b.moveBullet();
		        }
		
		        if (bulletDirection == Direction.DOWN) {
					if(b.getLocY() >= pHEIGHT) this.bullets.remove(b);
					else b.moveBullet();
		        }
			}
			
			if(this.bullets.size() == 0) this.bullets = null;
		}
		
	}
	
	/**
	 * adds one part to the snake and sets the new length
	 * @param d the dot that will be added to the snake
	 */
	public void expandSnake(Dot d){
		//int x = parts
		parts.add(d);
		this.length = parts.size();
		
	}
	
	public void createBullet(){
		if(this.length > 1){
			this.parts.remove(this.length - 1);
			this.length = parts.size();
			
			if(this.bullets == null) this.bullets = new ArrayList<Bullet>();
			System.out.println("*****   Bullet shoot!");	
			if (headingDirection == Direction.LEFT) bullets.add(new Bullet(DotTyp.BULLET, this.getHead().getLocX() - 10, this.getHead().getLocY(), this.headingDirection));
		    if (headingDirection == Direction.RIGHT) bullets.add(new Bullet(DotTyp.BULLET, this.getHead().getLocX() + 10, this.getHead().getLocY(), this.headingDirection));
		    if (headingDirection == Direction.UP) bullets.add(new Bullet(DotTyp.BULLET, this.getHead().getLocX(), this.getHead().getLocY() - 10, this.headingDirection));
		    if (headingDirection == Direction.DOWN) bullets.add(new Bullet(DotTyp.BULLET, this.getHead().getLocX(), this.getHead().getLocY() + 10, this.headingDirection));
		}
	}
	
	
	public Dot getHead(){
		if(length > 0){
			return getPart_i(0);
		}
		
		return null;
	}
	
	
	
	/**
	 * @return the bullets
	 */
	public List<Bullet> getBullets() {
		return bullets;
	}

	/**
	 * @param bullets the bullets to set
	 */
	public void setBullets(List<Bullet> bullets) {
		this.bullets = bullets;
	}

	/**
	 * @return the pWIDTH
	 */
	public int getpWIDTH() {
		return pWIDTH;
	}

	/**
	 * @return the pHEIGHT
	 */
	public int getpHEIGHT() {
		return pHEIGHT;
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
