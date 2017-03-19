package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
	 * creates the snake and other parts like walls and appels.
	 * creates the collison handler .
	 */
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
	
	public void showStart(){
		startFrame.setVisible(!startFrame.isVisible());
		Graphics g = gameFrame.getGraphics();
		g.setColor(Color.orange);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Game paused", (this.pWIDTH/2) - 70, this.pHEIGHT/2);
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
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Snake length:   " + this.snake.getLength(), 10, 35);

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
	
	/**
	 * Moves the snake and gives the collision handler the new collision matrix 
	 * and the the snake.
	 * @param d The direction in which  the snake is moving
	 */
	public void move(Direction d){
		this.snake.moveSnake(d);
		collisionHandler.setGameStats(this.collisionMatrix, this.snake);
		gamePanel.setInGame(collisionHandler.checkCollison());
	}
	
	/**
	 * sets the game stats:
	 * @param snake The new snake
	 * @param parts all the other parts
	 */
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