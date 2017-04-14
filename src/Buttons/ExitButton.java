package Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * The exit button
 * The application will be closed after pressing the buton.
 * @author stang
 *
 */
public class ExitButton  extends JButton{
	
	public ExitButton(){
		this.setText("Exit");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("*******************************Application stopped*******************************");
				System.exit(0);
				
			}
		});
		
	}
	

}

