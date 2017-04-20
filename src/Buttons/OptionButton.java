package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.GameOne;

import java.util.Random;

public class OptionButton  extends JButton{
	
	private int count = 0;
	
	public OptionButton(JPanel p){
		this.setText("Options");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count += 1;
				
				Random rn = new Random();
				int r = rn.nextInt(255);
				int g = rn.nextInt(255);
				int b = rn.nextInt(255);
				
				if(count == 10){
					count = 0;
					GameOne.getInstance().switchDeveloperMode();
					p.setBackground(new Color(1, 1, 1));
				}else{
					System.out.println("Changed Backgroundcolor: r:" + r + " | g:" + g + " | b:" + b);
					p.setBackground(new Color(r, g, b));
				}
				
				
				
			}
		});
		
	}
	

}
