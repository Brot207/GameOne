package GameWindow;


import Buttons.EndButton;
import Buttons.OptionButton;
import Buttons.StartButton;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartPanel extends JFrame{
	
	JPanel panel= null;

	public StartPanel(){
		panel = new JPanel(new GridLayout(3, 1));
		panel.setPreferredSize(new Dimension(300, 500));
	
		JButton start = new StartButton(panel);
		JButton exit = new EndButton();
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
