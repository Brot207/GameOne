/**
 * 
 */
package GameWindow;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author stang
 *
 */
public class GameFrame extends JFrame {
	
	public GameFrame(JPanel p){
		add(p);
		setResizable(false);
		pack();
		
		setTitle("GameOne -- SnakeAdvanced");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
