package GameObjects;

import java.util.ArrayList;
import java.util.List;

public class allWalls {
	
	private int wallSize = 10;
	private Wall wall = null;
	
	private List<Dot> parts = null;
	private int[][] wallMatrix;
	
	public allWalls(int level) { //level 1..2..3..
		this.wallMatrix[][] = setWallMatrix(level);
		/*if (level == 1){
			for (int i = 0; i < 10; i++) {
		        if (wall.getOrientation()) {
		        	this.collisionMatrix[wall.getLocX() + i*10][wall.getLocY()] = 1;
		        	g.drawImage(imageWall, wall.getLocX() + i*10, wall.getLocY(), gamePanel);
		        }
		        else {
		        	this.collisionMatrix[wall.getLocX()][wall.getLocY() + i*10] = 1;
		        	g.drawImage(imageWall, wall.getLocX(), wall.getLocY() + i*10, gamePanel);
		        }
		        }
		}*/
		
	}
	
	private int[][] setWallMatrix (int level) {
		if (level == 1){
			for (int i = 0; i < 10; i++) {
				this.wallMatrix[200+i*10][200] = 
			}
		}
	}
	

}
