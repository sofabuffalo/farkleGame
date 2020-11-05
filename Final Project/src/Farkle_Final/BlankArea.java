package Farkle_Final;


import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BlankArea extends JPanel{
	
	static JTextArea textArea;		//New Text area
	
	Dimension minSize = new Dimension(100, 100);	//Size of the space where the text area goes

	    public BlankArea() 
	    {
	    	//Create the Text Area
	    	textArea = new JTextArea();
	    	
	    	//Set it as Not editable
	        textArea.setEditable(false);
	        
	        //Give it a scrollPane so it automatically scrolls
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        scrollPane.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        
	        //Set the Size
	        scrollPane.setPreferredSize(new Dimension(400,90));
	        
	        //Add the scrollPane to the panel
	        add(scrollPane);
	    }
}

	   

