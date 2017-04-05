package GameObjects;

import java.util.ArrayList;
import java.util.List;

public class allWalls {
	
	private int[][] wallMatrix = new int [80][60]; //[column][row]
	
	public allWalls(int level) { //level 1..2..3..
		setMatrixZero();
		setWallMatrix(level);
		
	}
	
	private void setMatrixZero () {
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < 60; j++ ) {
				this.wallMatrix[i][j] = 0;
			}
		}
	}
	//Draw Level
	private void setWallMatrix (int level) {
		if (level == 1){
			//horizontals
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
	
	//Warning: Still needs code to place the apple where there's no wall
	
	public int getWallIndex (int n, int m) {
		return this.wallMatrix[n][m];
	}
	

}
