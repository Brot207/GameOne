package Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.GameOne;
import GameObjects.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShowSavesButton  extends JButton{
	
	
	public ShowSavesButton(){
		this.setText("Saves");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Level> lvs = new ArrayList<Level>();
				
				lvs = GameOne.getInstance().getSaves();
				System.out.println(lvs.size());
					
			}
		});
		
	}
	

}
