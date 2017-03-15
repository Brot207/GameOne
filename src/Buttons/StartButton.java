package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartButton  extends JButton{
	
	public StartButton(JPanel p){
		this.setText("Start");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setBackground(new Color(100, 10, 10));
				
			}
		});
		
	}
	

}
