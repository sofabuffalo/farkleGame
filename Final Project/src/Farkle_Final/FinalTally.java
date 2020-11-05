package Farkle_Final;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FinalTally extends JPanel{
		
	static final String NEWLINE = System.getProperty("line.separator");
	
	//Ued for the last message to display everyone's final tally
	public FinalTally()
	{
		FINALIE();
	}
	
	public void FINALIE()
	{
		String stats = "";
		
		for(int i = 1; i < FarkleGame.getMax() + 1; i++)
		{
			stats = stats + "Player " + i + " total points: " + DicePanel.playerPoints[i]  + NEWLINE;
		}
		
		JOptionPane.showMessageDialog(null, stats);
	}

}
