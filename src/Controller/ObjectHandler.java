/**
 * 
 */

package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import GameObjects.Dot;
import GameObjects.DotTyp;
import GameObjects.PowerUp;
import GameObjects.PowerUpTyp;
import GameObjects.Level;
import GameObjects.Snake;

public class ObjectHandler {
	
	private Snake snake = null;
	private List<Dot> otherParts = null;
	private Level level = null;
	private int[][] wallMatrix = new int [80][60]; //[column][row]
	
	public ObjectHandler (int lvl){  
	    snake = new Snake();
		otherParts = new ArrayList<Dot>();
		startingObjects();
		setWallMatrix(lvl);
		setWallObjects();
		level = new Level(snake, otherParts);
	}
	
	public ObjectHandler () { 
		
	}
	
	private void startingObjects(){
		otherParts.add(new Dot(DotTyp.HEAD, 100, 200));
		otherParts.add(new Dot(DotTyp.APPLE, 200, 200));
		otherParts.add(new PowerUp(PowerUpTyp.SHOOT, 300, 200)); //##############
		otherParts.add(new PowerUp(PowerUpTyp.SHOOT, 400, 200));
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public Snake getSnake() {
		return this.snake;
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
	
	public void saveLevel(Level level){
		File f = new File("Levels.txt");
		List<Level> levels = loadSavedLevels();
		levels.add(level);
		
		if(f.exists() && !f.isDirectory()){
			try {
				FileOutputStream ostream = new FileOutputStream(f);
				ObjectOutputStream objstream = new ObjectOutputStream(ostream);
				
				objstream.writeObject(levels);
				
				objstream.close();
				ostream.close();
			
			} catch (FileNotFoundException e) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!FILE_NOT_FOUND!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}	catch (IOException e) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!ERROR_INITIALIZING_STREAM!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}
		} else {
			try {
				FileOutputStream ostream = new FileOutputStream(new File("Levels.txt"));
				ObjectOutputStream objstream = new ObjectOutputStream(ostream);

				objstream.writeObject(levels);
				
				objstream.close();
				ostream.close();
			
			} catch (FileNotFoundException e) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!FILE_NOT_FOUND!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}	catch (IOException e) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!ERROR_INITIALIZING_STREAM!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}
		}
	}

	public List<Level> loadSavedLevels(){
		File f = new File("Levels.txt");
		List<Level> levels = new ArrayList<Level>();
		
		if(f.exists() && !f.isDirectory()){
			try {
				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);

	
				
				return levels = (List<Level>) oi.readObject();

			
			} catch (FileNotFoundException e) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!FILE_NOT_FOUND!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				//e.printStackTrace();
			}	catch (IOException e) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!ERROR_INITIALIZING_STREAM!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return levels;
	}
}
