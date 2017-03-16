package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.GameOne;

/**
 * The start button on the start panel.
 * The game will be started after pressing this button.
 * @author stang
 *
 */
public class StartButton  extends JButton{
	
	public StartButton(JPanel p){
		this.setText("Start");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//starts the game
				GameOne.getInstance().initGame();
				
			}
		});
		
	}
	

}
