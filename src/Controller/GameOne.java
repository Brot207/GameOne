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
	
	private static JFrame startFrame = null;
	private static JFrame gameFrame = null;
	
	private static GamePanel gamePanel = null;
	
	private int pHEIGHT = 600;
	private int pWIDTH = 800;
	
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
	public void gameLoop(){
        
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
		//creates the snake
		snake = new Snake();
		this.snake.setpWIDTH(this.pWIDTH);
		this.snake.setpHEIGHT(this.pHEIGHT);
		
		switchStartFrame();
		gameLoop();
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
		
		otherParts = new ArrayList<Dot>();
		otherParts.add(new Dot(DotTyp.HEAD, 100, 100));

        for (Dot d: snake.getParts()) {
            Image dot = d.getImage();
            g.drawImage(dot, d.getLocX(), d.getLocY(), gamePanel);
        }
        
        if(otherParts != null){
	        for(Dot d: otherParts){
	        	Image dot = d.getImage();
	        	 g.drawImage(dot, d.getLocX(), d.getLocY(), gamePanel);
	        }
        }
	}
	
	public void move(Direction d){
		this.snake.moveSnake(d);
		gamePanel.setInGame(checkCollision());
	}
	
	public boolean checkCollision(){
		Dot head = this.snake.getHead();
		
		for(int x = 1; x < snake.getLength(); x++){
			if(head.getLocX() == snake.getPart_i(x).getLocX() && head.getLocY() == snake.getPart_i(x).getLocY()){
				return !true;
			}
		}
		
		if(otherParts != null){
			for(Dot d: otherParts){
				if(head.getLocX() == d.getLocX() && head.getLocY() == d.getLocY()){
					return !true;
				}
			}
		}
		
		
		return !false;
		
	}
	

	//Just for startup
	public static void main(String[] args) {
		System.out.println("*******************************Application started*******************************");
		startFrame = new StartFrame();
	}
}