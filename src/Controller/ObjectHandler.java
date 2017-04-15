/**
 * 
 */

package Controller;

import java.util.ArrayList;
import java.util.List;

import GameObjects.Dot;
import GameObjects.DotTyp;
import GameObjects.PowerUp;

public class ObjectHandler {
	
	private List<Dot> otherParts = null;
	private int[][] wallMatrix = new int [80][60]; //[column][row]
	
	public ObjectHandler (int level){  //constructor is called once and loads all parts at the beginning of the game
		otherParts = new ArrayList<Dot>();
		startingObjects();
		setMatrixZero();
		setWallMatrix(level);
		setWallObjects();
	}
	
	private void startingObjects(){
		otherParts.add(new Dot(DotTyp.HEAD, 100, 200));
		otherParts.add(new Dot(DotTyp.APPLE, 200, 200));
		otherParts.add(new PowerUp(DotTyp.STAR, 300, 200));
		otherParts.add(new PowerUp(DotTyp.STAR, 400, 200));
	}
	
	private void setMatrixZero () {
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < 60; j++ ) {
				this.wallMatrix[i][j] = 0;
			}
		}
	}
	//DRAW LEVEL
	private void setWallMatrix (int level) {
		if (level == 1){
			//horizontal
			for (int i = 0; i < 60; i++) {
				this.wallMatrix[10+i][10] = 1;
				this.wallMatrix[10+i][50] = 1;
			}
			//verticals
			for (int j = 0; j < 41; j++) {
				this.wallMatrix[10][10+j] = 1;
				this.wallMatrix[70][10+j] = 1;
			}
		}
		
	}
	
	private void setWallObjects(){
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < 60; j++) {
				if (this.wallMatrix[i][j] == 1) {
					otherParts.add(new Dot(DotTyp.WALL, 10*i, 10*j));
				}
			}
		}
	}
	
		public int getWallIndex(int n, int m) {
			return this.wallMatrix[n][m];
		}
	
	
	public List<Dot> getOtherParts(){
		return this.otherParts;
	}

}
