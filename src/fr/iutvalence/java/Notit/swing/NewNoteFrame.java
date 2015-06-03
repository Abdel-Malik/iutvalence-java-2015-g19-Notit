package fr.iutvalence.java.Notit.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class NewNoteFrame extends JFrame{

	public NewNoteFrame(){


		this.setTitle("NotIt");
		this.setSize(1024, 768); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
		/**
		 * JLabel
		 */
		JLabel addNoteLabel = new JLabel("Add new note", JLabel.CENTER);
		JLabel title = new JLabel("Title :");
		JLabel contents = new JLabel("Contents :");
		

		
	}
}
