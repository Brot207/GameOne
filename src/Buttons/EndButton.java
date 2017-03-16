package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The exit button
 * The application will be closed after pressing the buton.
 * @author stang
 *
 */
public class EndButton  extends JButton{
	
	public EndButton(){
		this.setText("Exit");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
	}
	

}

