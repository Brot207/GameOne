package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.Random;

public class OptionButton  extends JButton{
	
	public OptionButton(JPanel p){
		this.setText("Options");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Random rn = new Random();
				int r = rn.nextInt(255);
				int g = rn.nextInt(255);
				int b = rn.nextInt(255);
				
				System.out.println("Changed Backgroundcolor: r:" + r + " | g:" + g + " | b:" + b);
				p.setBackground(new Color(r, g, b));
				
			}
		});
		
	}
	

}
