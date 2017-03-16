package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;

import GameObjects.Snake;
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
		//creates the snake
		Snake snake = new Snake();
        
        EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				//creates the Frame where our game panel will fit in.
				JFrame f = new JFrame();
				f.add(new GamePanel(snake));
				f.setResizable(false);
				f.pack();
				f.setTitle("GameOne -- SnakeAdvanced");
				f.setLocationRelativeTo(null);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        
				f.setVisible(true);
				System.out.println("game has started");
				
			}
        	
        });
	}
	
	/**
	 * Starts the game
	 */
	public void initGame(){
		hideStartFrame();
		gameLoop();
	}
	
	/**
	 * hides the start Frame
	 */
	public void hideStartFrame() {
		startFrame.setVisible(false);
	}

	//Just for startup
	public static void main(String[] args) {
		startFrame = new StartFrame();
	}
}