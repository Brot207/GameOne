package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import GameObjects.Dot;
import GameObjects.DotTyp;
import GameObjects.Snake;

/**
 * This is the collision handler.
 * He checks if there is an collision and also reacts to it
 * @author Stang
 *
 */
public class CollisionHandler {
	
	private List<Snake> snakes = null;
	private Snake snake = null;
	private List<Dot> otherParts = null;
	
	private boolean collison = !false;
	private int[][] collisionMatrix;
	
	
	/**
	 * constructor
	 * @param otherParts all the parts but the snake
	 */
	public CollisionHandler(List<Dot> otherParts){
		this.otherParts = new ArrayList<Dot>();
		
		this.otherParts = otherParts;
	}
	
	
	/**
	 * checks if there is an collision and decides what to do.
	 * @return !false if there is no collision || !true if there is an collison
	 */
	public boolean checkCollison(){
		Dot head = this.snake.getHead();
		int indexToCheck = this.collisionMatrix[head.getLocX()][head.getLocY()];
		if( indexToCheck < 0){
			indexToCheck *= -1;
			indexToCheck -= 1;
			if(otherParts.get(indexToCheck).getTyp() == DotTyp.APPLE){
				Dot apple = otherParts.get(indexToCheck);
				apple.setTyp(DotTyp.BODYPART);
				this.snake.expandSnake(apple);
				otherParts.remove(indexToCheck);
				generateNewApple();
				GameOne.getInstance().setGameStats(this.snake, this.otherParts);
				return !false;
			}
			
			return !true;
		}else if(indexToCheck > 0){
			if(indexToCheck == 2) return !false;
			return !true;
		}
		
		return !false;
	
	}
	
	public void generateNewApple(){
		int width = this.snake.getpWIDTH() / 10;
		int height = this.snake.getpHEIGHT() / 10;
		
		Random rn = new Random();
		
		boolean newApple = false;
		
		while(!newApple){
			int x = rn.nextInt(width) * 10 ;
			int y = rn.nextInt(height) * 10;
			
			if(this.collisionMatrix[x][y] != 0){
				continue;
			}
			
			Dot apple = new Dot(DotTyp.APPLE, x, y);
			otherParts.add(apple);
			newApple = true;
		}
		

		
		

	}
	
	public void setGameStats(int[][] collision, Snake snake){
		this.collisionMatrix = collision;
		this.snake = snake;
	}
	
	public void setCollisionMatrix(int[][] list){
		this.collisionMatrix = list;
	}


	/**
	 * @param snakes the snakes to set
	 */
	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}
	
	
	
		
}

