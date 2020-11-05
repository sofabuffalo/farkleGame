package Farkle_Final;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random; 

public class DicePanel extends JPanel{
	
	private JButton die1Button;        // A button to hold an image
	private JButton die2Button;        // A button to hold an image
	private JButton die3Button;        // A button to hold an image
	private JButton die4Button;        // A button to hold an image
	private JButton die5Button;        // A button to hold an image
	private JButton die6Button;        // A button to hold an image
    private ImageIcon die1Image;     // To hold an image of die1
	private ImageIcon die2Image;     // To hold an image of die2
	private ImageIcon die3Image;     // To hold an image of die3
	private ImageIcon die4Image;     // To hold an image of die4
	private ImageIcon die5Image;     // To hold an image of die5
	private ImageIcon die6Image;     // To hold an image of die6
	
	private ArrayList<ImageIcon> dieImageList;  // To hold the die images.
	
	static String maxPlayer = null;          //Final int to easily change how many players are playing
	int count = 0;					//To keep track of how many dice are selected/taken out		
	static int[] playerPoints;	    //Keeping track of player's points using an array
	static int player;				//To keep track of what player is playing
	
	static final String NEWLINE = System.getProperty("line.separator");		//To set each text on a new line in the JTextArea
	
	public DicePanel()
	{
		//Set the player as player One to start
		player = 1;
		
		//Player points can get up to three before reseting
		playerPoints = new int[FarkleGame.getMax() + 1];
		
		//Set the layout of THIS panel
		setLayout(new GridLayout(2,3));
		
		//Build the dieImageList
		buildDieImageList();
		
		//Create the JButtons
		die1Button = new JButton();
		die2Button = new JButton();
		die3Button = new JButton();
		die4Button = new JButton();
		die5Button = new JButton();
		die6Button = new JButton();
		
		//Set Action Listeners for each button
		die1Button.addActionListener(new button1());
		die2Button.addActionListener(new button2());
		die3Button.addActionListener(new button3());
		die4Button.addActionListener(new button4());
		die5Button.addActionListener(new button5());
		die6Button.addActionListener(new button6());
		
		// Add the buttons to the content pane.
	    add(die1Button);
	    add(die2Button);
	    add(die3Button);
	    add(die4Button);
	    add(die5Button);
	    add(die6Button);
	}
	
	//The dieImageList that is built to add images to the panel
	private void buildDieImageList()
	   {
	      // Create the dieImageList ArrayList to hold the ImageIcon objects.
	      dieImageList = new ArrayList<ImageIcon>();

	      // Add the ImageIcon objects to the dieImageList ArrayList
	      dieImageList.add(new ImageIcon("Dice\\Die1.png"));
	      dieImageList.add(new ImageIcon("Dice\\Die2.png"));
	      dieImageList.add(new ImageIcon("Dice\\Die3.png"));
	      dieImageList.add(new ImageIcon("Dice\\Die4.png"));
	      dieImageList.add(new ImageIcon("Dice\\Die5.png"));
	      dieImageList.add(new ImageIcon("Dice\\Die6.png"));
	   }
	
	
	//The method to roll the dice
	 public void rollDice()
	   {
	      // Create a reference to a Random object.
	      Random rand = new Random();

	      // Generate a random number between 0 and the number of items in the array list, and store the value in the index variables.
	      int index1 = rand.nextInt(dieImageList.size());
	      int index2 = rand.nextInt(dieImageList.size());
	      int index3 = rand.nextInt(dieImageList.size());
	      int index4 = rand.nextInt(dieImageList.size());
	      int index5 = rand.nextInt(dieImageList.size());
	      int index6 = rand.nextInt(dieImageList.size());

	      // Get images from the array list using the index values that were generated.
	      die1Image = dieImageList.get(index1);
	      die2Image = dieImageList.get(index2);
	      die3Image = dieImageList.get(index3);
	      die4Image = dieImageList.get(index4);
	      die5Image = dieImageList.get(index5);
	      die6Image = dieImageList.get(index6);

	      // Display the dice.
	      die1Button.setIcon(die1Image);
	      die2Button.setIcon(die2Image);
	      die3Button.setIcon(die3Image);
	      die4Button.setIcon(die4Image);
	      die5Button.setIcon(die5Image);
	      die6Button.setIcon(die6Image);
	   }
	 
	 //Checking Results
	 public void checkResults(Object die)
	 {	 
		 if (((AbstractButton) die).getIcon() == dieImageList.get(0))
		 	{
			 	count++;
			 	BlankArea.textArea.append("+100" + NEWLINE);
			 	playerPoints[player] += 100;
			 	((AbstractButton) die).setVisible(false);
			 	FarkleGame.quitButton.setEnabled(true);
		 	}
		 
		 else if (((AbstractButton) die).getIcon() == dieImageList.get(4))
		 	{
			 	count++;
			 	BlankArea.textArea.append("+50" + NEWLINE);
			 	playerPoints[player] += 50;
			 	((AbstractButton) die).setVisible(false);
			 	FarkleGame.quitButton.setEnabled(true);	 		
		 	}
		
		 if (count == 6)
		 	{
			 	reset();
		 	}
		 
		 
		
	 }
	 
	 //Method used to reset the game
	 public void reset()
	 {
		die1Button.setVisible(true);
		die2Button.setVisible(true);
		die3Button.setVisible(true);
		die4Button.setVisible(true);
		die5Button.setVisible(true);
		die6Button.setVisible(true);
		count = 0;
	 }
	 
	 
	 //The Action Listeners for each button
	 private class button1 implements ActionListener
	   {
		 public void actionPerformed(ActionEvent e)
	      {
		 	checkResults(die1Button);
	      }
	   }
	 
	 private class button2 implements ActionListener
	   {
		 public void actionPerformed(ActionEvent e)
	      {
			 checkResults(die2Button);
	      }
	   }
	 
	 private class button3 implements ActionListener
	   {
		 public void actionPerformed(ActionEvent e)
	      {
			 checkResults(die3Button);
	      }
	   }
	 
	 private class button4 implements ActionListener
	   {
		 public void actionPerformed(ActionEvent e)
	      {
			 checkResults(die4Button);
	      }
	   }
		 
	 private class button5 implements ActionListener
	   {
		 public void actionPerformed(ActionEvent e)
	      {
			 checkResults(die5Button);
	      }
	   }
	 
	 private class button6 implements ActionListener
	   {
		 public void actionPerformed(ActionEvent e)
	      {
			 checkResults(die6Button);
	      }
	   } 
}
