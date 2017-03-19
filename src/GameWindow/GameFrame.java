/**
 * 
 */
package GameWindow;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author stang
 *
 */
public class GameFrame extends JFrame {
	
	public GameFrame(JPanel p){
		
		
		add(p, BorderLayout.CENTER);
		setResizable(false);
		pack();
		
		setTitle("GameOne -- SnakeAdvanced");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
