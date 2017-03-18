package Controller;

import java.util.ArrayList;
import java.util.List;

import GameObjects.Dot;
import GameObjects.DotTyp;
import GameObjects.Snake;

public class CollisionHandler {
	
	private List<Snake> snakes = null;
	private Snake snake = null;
	private List<Dot> otherParts = null;
	
	private boolean collison = !false;
	private int[][] collisionMatrix;
	
	public CollisionHandler(List<Dot> otherParts){
		this.otherParts = new ArrayList<Dot>();
		
		this.otherParts = otherParts;
	}
	
	
	
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
				System.out.println(otherParts.size());
				GameOne.getInstance().setGameStats(this.snake, this.otherParts);
				return !false;
			}
			return !true;
		}else if(indexToCheck > 0){
			return !true;
		}
		
		return !false;
	
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

