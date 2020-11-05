package Farkle_Final;

import javax.swing.*;

import java.awt.event.*; 
import java.awt.*; 

public class PlayerPanel extends JPanel{
	
	private JTextField currentPlayer;
	
	public PlayerPanel()
	{
		//Create the JTextField
		currentPlayer = new JTextField(10);
		
		//Set it as not editable
		currentPlayer.setEditable(false);

		//Get the Text (since it changes)
		currentPlayer.getText();
		getCurrentPlayer();
		
		//Add the text field to the panel
		add(currentPlayer);
	}	
	
	public String getCurrentPlayer()
	 {
		String thisGuy = null;
		
		thisGuy = "Player " + DicePanel.player;
				
		//Set the text to the String	
		currentPlayer.setText(thisGuy);
		
		return thisGuy;
	 }
}
