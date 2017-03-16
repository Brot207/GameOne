package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;

import GameObjects.Snake;
import GameWindow.GamePanel;

public class GameController {
	
	static GameController instance = null;
	
	
	private GameController(){
		
	}
	
	public static GameController getInstance(){
		if(instance == null){
			instance = new GameController();
		}
		
		return instance;
	}
	
	public void gameLoop(){
		Snake snake = new Snake();
//		JFrame f = new JFrame();
//		f.add(new GamePanel(snake));
//		f.setResizable(false);
//		f.pack();
//		f.setTitle("GameOne -- SnakeAdvanced");
//		f.setLocationRelativeTo(null);
//      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new JFrame();
				f.add(new GamePanel(snake));
				f.setResizable(false);
				f.pack();
				f.setTitle("GameOne -- SnakeAdvanced");
				f.setLocationRelativeTo(null);
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
				f.setVisible(true);
				System.out.println("1");
				
			}
        	
        });
	}
}