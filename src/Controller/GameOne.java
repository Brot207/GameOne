package Controller;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GameObjects.Dot;
import GameObjects.DotTyp;
import GameObjects.Snake;
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
	
	private static JFrame startFrame = null;
	private static JFrame gameFrame = null;
	
	private static GamePanel gamePanel = null;
	
	private int pHEIGHT = 600;
	private int pWIDTH = 800;
	
	private int[][] collisionMatrix;
	
	private Snake snake;
	private List<Dot> otherParts = null;
	
	private GameOne(){
		
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
				gamePanel = new GamePanel(pHEIGHT, pWIDTH);
				gameFrame = new GameFrame(gamePanel);
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
	
	public void loadGame(){
		//creates the snake
		snake = new Snake();
		this.snake.setpWIDTH(this.pWIDTH);
		this.snake.setpHEIGHT(this.pHEIGHT);
		
		otherParts = new ArrayList<Dot>();
		otherParts.add(new Dot(DotTyp.HEAD, 100, 100));
		otherParts.add(new Dot(DotTyp.APPLE, 200, 100));
		
		collisionHandler = new CollisionHandler(this.otherParts);
		
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
	
	public void doDrawingOnGamePanel(Graphics g){

		this.collisionMatrix = new int[this.pWIDTH+1][this.pHEIGHT+1];
		
		boolean head = true;
		
        for (Dot d: snake.getParts()) {
            Image dot = d.getImage();
            if(head){
            	this.collisionMatrix[d.getLocX()][d.getLocY()] = 1;
            	 g.drawImage(dot, d.getLocX(), d.getLocY(), gamePanel);
            	head = false;
            	continue;
            }
            this.collisionMatrix[d.getLocX()][d.getLocY()] = 1;
            g.drawImage(dot, d.getLocX(), d.getLocY(), gamePanel);
        }
        
        if(otherParts != null){
	        for(int z = 0; z < otherParts.size(); z++){
	        	Dot d = otherParts.get(z);
	        	Image dot = d.getImage();
	        	this.collisionMatrix[d.getLocX()][d.getLocY()] = -(z+1);
	        	 g.drawImage(dot, d.getLocX(), d.getLocY(), gamePanel);
	        }
        }
	}
	
	public void move(Direction d){
		this.snake.moveSnake(d);
		collisionHandler.setGameStats(this.collisionMatrix, this.snake);
		gamePanel.setInGame(collisionHandler.checkCollison());
	}
	
	public void setGameStats(Snake snake, List<Dot> parts){
		this.snake = snake;
		this.otherParts = parts;
	}
	
	//Just for startup
	public static void main(String[] args) {
		System.out.println("*******************************Application started*******************************");
		startFrame = new StartFrame();
	}
}