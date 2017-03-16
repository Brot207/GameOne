package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;

import GameObjects.Snake;
import GameWindow.GamePanel;

/**
 * Controlls the game.
 * The Controller can only be initialized once. Thats why the Constructor is private. 
 * Creates the game panel, the snake and other obstacles.
 *  
 * @author stang
 *
 */
public class GameController {
	
	static GameController instance = null;
	
	
	private GameController(){
		
	}
	
	/**
	 * Returns the instance of the Controller and of there is none, the instance will be created.
	 * @return
	 */
	public static GameController getInstance(){
		if(instance == null){
			instance = new GameController();
		}
		
		return instance;
	}
	
	/**
	 * The actual game loop.
	 * This is where the game is running onced it started. 
	 */
	public void gameLoop(){
		//creates the snake
		Snake snake = new Snake();
		
		//creates the Frame where our game panel will fit in.
		JFrame f = new JFrame();
		f.add(new GamePanel(snake));
		f.setResizable(false);
		f.pack();
		f.setTitle("GameOne -- SnakeAdvanced");
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
		        JFrame frame = f;
		        
				frame.setVisible(true);
				System.out.println("1");
				
			}
        	
        });
	}
}