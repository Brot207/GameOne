package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GameObjects.Bullet;
import GameObjects.Dot;
import GameObjects.DotTyp;
import GameObjects.PowerUp;
import GameObjects.Snake;
import GameObjects.Wall;
import GameObjects.Level;
import GameWindow.Direction;
import GameWindow.GameFrame;
import GameWindow.GamePanel;
import GameWindow.StartFrame;

/**
 * Controlls the game.
 * The Controller can only be initialized once. Thats why the Constructor is private. 
 * Creates the game panel, the snake and other obstacles.
 *  
 * @author stang
 *
 */
public class GameOne {
	
	private static GameOne instance = null;
	private static CollisionHandler collisionHandler= null;
	private static TimerEventHandler eventHandler = null;
	private static ObjectHandler objectHandler = null;
	
	private static JFrame startFrame = null;
	private static JFrame gameFrame = null;
	
	private static GamePanel gamePanel = null;
	
	private boolean developerMode = false;
	
	private int pHEIGHT = 600;
	private int pWIDTH = 800;
	private int gameTickCount = 0;
	
	private int lvl = 1;
	
	private int[][] collisionMatrix;
	
	private Snake snake;
	private List<Dot> otherParts = null;
	private Level level;
	
	private GameOne(){
		objectHandler = new ObjectHandler();
	}
	
	/**
	 * Returns the instance of the Controller and of there is none, the instance will be created.
	 * @return
	 */
	public static GameOne getInstance(){
		if(instance == null){
			instance = new GameOne();
		}
		
		return instance;
	}
	
	/**
	 * The actual game loop.
	 * This is where the game is running once it's started. 
	 */
	public void gameLoopInit(){
        
        EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				//creates the Frame where our game panel will fit in.
				gameTickCount = 0;
				gamePanel = new GamePanel(pHEIGHT, pWIDTH);

				
				gameFrame = new GameFrame(gamePanel);
				gameFrame.setAlwaysOnTop(true);
				gameFrame.setVisible(true);
				System.out.println("*********************************************************************************");
				System.out.println("Game has started");
				
			}
        	
        });
	}
	
	/**
	 * Starts the game
	 */
	public void initGame(){
		loadGame();
		switchStartFrame();
		gameLoopInit();
	}
	
	/**
	 * creates the snake and other parts like walls and apples.
	 * creates the collision handler .
	 */
	public void loadGame(){
	
		objectHandler = new ObjectHandler(lvl);
		level = objectHandler.getLevel(); 
		snake = level.getSnake();
		otherParts = level.getOtherParts();
		
		collisionHandler = new CollisionHandler(this.otherParts);
		eventHandler = new TimerEventHandler(otherParts);
		
		
		if(developerMode){
			otherParts = null;
			snake = new Snake(1);
			snake.setpHEIGHT(pHEIGHT);
			snake.setpWIDTH(pWIDTH);
			this.collisionMatrix = new int[this.pWIDTH+1][this.pHEIGHT+1];
		}
	}
	
	public void showStart(){
		startFrame.setVisible(!startFrame.isVisible());
		gameFrame.setVisible(true);
	}
	
	/**
	 * hides the start Frame
	 */
	public void switchStartFrame() {
		if(startFrame.isVisible()) {
			startFrame.setVisible(false);
		}else{
			startFrame.setVisible(true);
			gameFrame.dispose();
		}
	}
	
	/**
	 * Draws all the Game Objects on the game Panel.
	 * It also sets the collision matrix.
	 * ABOUT THE COLLISION MATRIX:
	 * -int[panel width][panel height]
	 * - if entry ij == 0 ==> no game object on the panel at x = i and y = j
	 * - if entry is < 0 ==> there is a wall or apple
	 * - if entry > 0 ==> there is the snake
	 * @param g
	 */
	public void doDrawingOnGamePanel(Graphics g){
		gameTickCount += 1;
		eventHandler.makeCall(gameTickCount);

		this.collisionMatrix = new int[this.pWIDTH+1][this.pHEIGHT+1];
		
		int count = 1;
        for (Dot d: snake.getParts()) {
            count += 1;
            Image dot = d.getTyp().getImageIcon().getImage();
            if(d.getTyp() == DotTyp.HEAD){
            	this.collisionMatrix[d.getLocX()][d.getLocY()] = 0;
            	g.drawImage(dot, d.getLocX(), d.getLocY(), gamePanel);
            	continue;
            }
            this.collisionMatrix[d.getLocX()][d.getLocY()] = count + 2;
            g.drawImage(dot, d.getLocX(), d.getLocY(), gamePanel);
        }
        
        if(otherParts != null){
	        for(int z = 0; z < otherParts.size(); z++){
	        	Dot d = otherParts.get(z);
	        	Image dot = d.getTyp().getImageIcon().getImage();
	        	this.collisionMatrix[d.getLocX()][d.getLocY()] = -(z+1);
	        	g.drawImage(dot, d.getLocX(), d.getLocY(), gamePanel);
	        }
        }
        
        if(snake.getBullets() != null){
        	for(Bullet b: snake.getBullets()){
        		Image dot = b.getTyp().getImageIcon().getImage();
            	g.drawImage(dot, b.getLocX(), b.getLocY(), gamePanel);
        	}
        }
        
        if(developerMode){
        	g.setColor(Color.LIGHT_GRAY);
        	g.drawString("Move:   use ARROW KEYS", 10, 20);
        	g.drawString("Set or remove a wall on your current location:   press F", 10, 35);
        }else{
        	g.setColor(Color.LIGHT_GRAY);
        	g.drawString("game is running     " + gameTickCount, 10, 20);
    		g.drawString("Snake length:   " + this.snake.getLength(), 10, 35);
        }
	}
	
	/**
	 * Moves the snake and gives the collision handler the new collision matrix 
	 * and the the snake.
	 * @param d The direction in which  the snake is moving
	 */
	public void move(Direction d){
		if(!developerMode){
			if(gameTickCount % 2 == 0){
				this.snake.moveSnake(d);
				gamePanel.setInGame(collisionHandler.checkCollison(this.collisionMatrix, this.snake));
			}
			this.snake.moveBullet();
			collisionHandler.checkBulletCollision(this.snake);
		}
	}
	
	public void developerMove(Direction d){
		if(developerMode){
			this.snake.moveSnake(d);
		}
	}
	
	public void fAction(){
		if(!developerMode){
			this.snake.createBullet();
		}else{
			int x = snake.getHead().getLocX();
			int y = snake.getHead().getLocY();
			if(collisionMatrix[x][y] == 0) {
				collisionMatrix[x][y] = 1;
				if(otherParts != null){ 
					otherParts.add(new Dot(DotTyp.WALL, x, y));
				}else{
					otherParts = new ArrayList<Dot>();
					otherParts.add(new Dot(DotTyp.WALL, x, y));
				}
			}
			else{
				for(Dot d: otherParts){
					if(d.getLocX() == x && d.getLocY() == y){
						otherParts.remove(d);
						break;
					}
				}
			}
		}
	}
	
	public void saveLevel(){
		if(developerMode) {
			this.level.setOtherParts(otherParts);
			objectHandler.saveLevel(level);
		}
	}
	
	public List<Level> getSaves(){
		return objectHandler.loadSavedLevels();
	}
	
	/**
	 * sets the game stats:
	 * @param snake The new snake
	 * @param parts all the other parts
	 */
	public void setSnake(Snake snake){
		this.snake = snake;
	}
	
	public void gameOver(){
		gamePanel.setInGame(false);
	}
	
	public void setOtherParts(List<Dot> list){
		this.otherParts = list;
		eventHandler.setObserver(otherParts);
	}
	
	public List<Dot> getOtherParts(){
		return this.otherParts;
	}
	
	public void switchDeveloperMode(){
		this.developerMode = !this.developerMode;
		System.out.println("*********************************************************************************");
		System.out.println();
		System.out.println("Developer Mode: " + developerMode);
		System.out.println();
		System.out.println("*********************************************************************************");
	}
	
	//Just for startup
	public static void main(String[] args) {
		System.out.println("*******************************Application started*******************************");
		startFrame = new StartFrame();
	}
}