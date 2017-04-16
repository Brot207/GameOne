package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import GameObjects.Bullet;
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
	
	private Snake snake = null;
	private List<Dot> otherParts = null;
	
	private int[][] collisionMatrix;
	
	private static CollisionHandler collisionHandler= null;
	private static TimerEventHandler eventHandler = null;
	
	
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
	 * @return !false if there is no collision || !true if there is an collision
	 */
	public boolean checkCollison(int[][] collision, Snake snake){
		this.otherParts = GameOne.getInstance().getOtherParts();
		this.collisionMatrix = collision;
		this.snake = snake;
		
		Dot head = this.snake.getHead();
		int indexToCheck = this.collisionMatrix[head.getLocX()][head.getLocY()];
		
		//Something is in the way
		if( indexToCheck < 0){
			indexToCheck *= -1;
			indexToCheck -= 1;
			//if object is an apple
			if(otherParts.get(indexToCheck).getTyp() == DotTyp.APPLE){
				Dot apple = otherParts.get(indexToCheck);

				apple.killDot();
				
				this.snake.expandSnake(apple);
				generateNewApple();
				GameOne.getInstance().setSnake(this.snake);
				return !false;
			}
			
			System.out.println("**** snake crashed!");
			return !true;
		//the snake hits it self
		}else if(indexToCheck > 0){
			if(indexToCheck == 2) return !false;
			//to avoid collision after an apple is consumed
			if(this.snake.getParts().get(indexToCheck - 4).getTyp() == DotTyp.APPLE){
				return !false;
			}
			System.out.println("****2 snake crashed!");
			return !true;
		}
		
		return !false;
	}
	
	public void checkBulletCollision(Snake s){
		this.snake = s;
		
		if(this.snake.getBullets() != null){
			for(int x = 0; x < this.snake.getBullets().size(); x++){
				Bullet b = this.snake.getBullets().get(x);
				int indexToCheck = this.collisionMatrix[b.getLocX()][b.getLocY()];
				if(indexToCheck != 0){
					System.out.println("*********** Bullet hit!");
					List<Bullet> bullets = this.snake.getBullets();
					bullets.remove(b);
					

					indexToCheck *= -1;
					indexToCheck -= 1;
					
					System.out.println("*********** One bullet removed!");
					this.snake.setBullets(bullets);
					
					Dot dotOfInterest = GameOne.getInstance().getOtherParts().get(indexToCheck);
					if(dotOfInterest.getTyp() == DotTyp.APPLE){
						dotOfInterest.killDot();
						generateNewApple();
					}
					else{
						dotOfInterest.killDot();
					}
				}
				else if(indexToCheck > 0){		
					GameOne.getInstance().gameOver();
				}
			}
		}
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
}

