package GameWindow;


import Buttons.ExitButton;
import Buttons.OptionButton;
import Buttons.StartButton;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The start frame of the application
 * @author stang
 *
 */
public class StartFrame extends JFrame{
	
	JPanel panel= null;

	public StartFrame(){
		panel = new JPanel(new GridLayout(4, 1));
		panel.setPreferredSize(new Dimension(300, 500));
	
		JButton start = new StartButton();
		JButton exit = new ExitButton();
		JButton config = new OptionButton(panel);
		panel.add(start);	
		panel.add(config);
		panel.add(exit);
		
		add(panel);
		pack();
		
		setTitle("SnakeAdvanced");
		setResizable(false);
		setLocation(10, 10);
		
		setVisible(true);
	
	
	}
	
	public JPanel getPanel() {
		return panel;
	}


}
