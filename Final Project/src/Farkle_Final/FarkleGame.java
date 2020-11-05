package Farkle_Final;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent; 

public class FarkleGame extends JFrame{
	
	private DicePanel dice;				//Create the object for the Dice Panel
	private PlayerPanel player;			//Create the object for the Player Panel
	private BlankArea blankArea;		//Create the object for the Blank Area
	private FinalTally finalTally;		//Create the object for the Final Tally
	
	private JButton rollButton;      	// A button to get roll the dice
    public static JButton quitButton;   // A button to quit
    public JButton exitButton;			//A button to exit
    private JPanel rollAndQuitPanel; 	//A panel to hold both buttons for BorderLayout
    
    private int oldScore;				//To keep track of Player's oldScore
    
    static final String NEWLINE = System.getProperty("line.separator"); 	//To set each text on a new line in the JTextArea
    
	
	public FarkleGame()
	{
		//Set the layout of THIS panel
		setLayout(new BorderLayout());
		
		//Title
		setTitle("Farkle Game");
		
		//Close button
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 //Custom panels
		 dice = new DicePanel();
		 player = new PlayerPanel();
		 blankArea = new BlankArea();
		 
		
		 //Roll and Quit Buttons
		 buildButtonPanel();
		 
		 //Call the Roll Dice method to roll the dice initially (and show the images)
		 dice.rollDice();
		 
		 //Add components to the content pane
		 add(dice, BorderLayout.NORTH);
		 add(player, BorderLayout.WEST);
		 add(rollAndQuitPanel, BorderLayout.EAST);
		 add(blankArea, BorderLayout.SOUTH);
		 
		 //Pack contents of the window and display them
		 pack();
		 setVisible(true);
	}
	
	//A Build Panel for the Roll and Quit Buttons
	private void buildButtonPanel()
	   {
	      // Create a panel.
	      rollAndQuitPanel = new JPanel();

	      // Create the roll button.
	      rollButton = new JButton("Roll the Dice");
	      rollButton.setMnemonic(KeyEvent.VK_R);
	      rollButton.setToolTipText("Click here to roll the dice");
	                	      
	      //Create the quit button.
	      quitButton = new JButton("Quit");
	      quitButton.setMnemonic(KeyEvent.VK_R);
	      quitButton.setToolTipText("Click here to quit while you're ahead");
	      quitButton.setEnabled(false);
	      
	      //Create an exit button.
	      exitButton = new JButton("Exit");
	      exitButton.setMnemonic(KeyEvent.VK_R);
	      exitButton.setToolTipText("Click here to exit the program");

	      // Register an action listener with the buttons.
	      rollButton.addActionListener(new RollButtonListener());
	      quitButton.addActionListener(new QuitButtonListener());
	      exitButton.addActionListener(new ExitButtonListener());

	      // Add the button to the panel.
	      rollAndQuitPanel.add(rollButton);
	      rollAndQuitPanel.add(quitButton);
	      rollAndQuitPanel.add(exitButton);
	   }
	
	public static int getMax()
	{
		int max = Integer.parseInt(DicePanel.maxPlayer);
		return max;
	}
	
	//Action Listeners for Rolling the Die and Quitting
	 private class RollButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  dice.rollDice();
	    	  quitButton.setEnabled(false);	
	    	      	  	    	  
	    		if(oldScore == dice.playerPoints[dice.player])
	    		  	{
	    			  dice.reset();
	    			  BlankArea.textArea.append("Player " + dice.player + " lost all " + dice.playerPoints[dice.player] + 
	    					  " of their points." + NEWLINE);
	    			  dice.playerPoints[dice.player] = 0;
	    			  BlankArea.textArea.append("Player " + dice.player + " has " + dice.playerPoints[dice.player] + 
	    					  " points" + NEWLINE);
	    			  dice.player++;
	    			  player.getCurrentPlayer();
	    		  	}
	    		
	    		if (dice.player > getMax())
			  	{
			  		dice.player = 1;
			  		player.getCurrentPlayer();
			  	}
	    	 	
	    		oldScore = dice.playerPoints[dice.player];
	      }
	   }
	 
	 private class QuitButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 dice.reset();
	    	 quitButton.setEnabled(false);
	    	 dice.rollDice();
	    	 BlankArea.textArea.append("Player " + dice.player + " total points: " + dice.playerPoints[dice.player] + NEWLINE);
	    	 dice.player++;
	    	 
	    	 if (dice.player > getMax())
			  	{
			  		dice.player = 1;
			  		player.getCurrentPlayer();
			  	}
	    	 
	    	 
	    	 player.getCurrentPlayer();
	    	 oldScore = dice.playerPoints[dice.player]; 	   
	      }
	   }
	 
	 private class ExitButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  finalTally = new FinalTally();
	    	  
	    	  System.exit(0);
	      }
	   }
	      

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String whatTheUserEntered = JOptionPane.showInputDialog("Enter the amount of players.");
		DicePanel.maxPlayer = whatTheUserEntered;
		int max = Integer.parseInt(DicePanel.maxPlayer);
		
		JOptionPane.showMessageDialog(null, "The rules of the game are simple. You start with six dice to roll."
				+ "\nEvery time you get a one, one hundred points are added to your score."
				+ "\nWhen you roll a five, fifty points are added to your score."
				+ "\nWhen face value is counted, those die are taken out of the pile and you"
				+ "\nare left to roll the remaining dice. You MUST take at least one die out to remain in the game."
				+ "\nIf you quit while you're ahead, you can keep your points till your next turn."
				+ "\nIf you roll your dice and get nothing... then you lose EVERYTHING!"
				+ "\nPlayer One: You start.");
		
		new FarkleGame();
			
	}
}
