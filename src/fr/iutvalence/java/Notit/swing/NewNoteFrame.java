package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import fr.iutvalence.java.Notit.Date;

public class NewNoteFrame extends JFrame{

	private JButton addNoteButton;
	private JLabel titleLabel;
	private JLabel contentsLabel;
	private JTextField titleText;
	private JTextField contentsText;
	private JSplitPane titleSplitPane;
	private JSplitPane contentsSplitPane;
	private Date date;
	
	public NewNoteFrame(){
		theFrame();
	}
	
	public NewNoteFrame(Date date){
		this.date=date;
		theFrame();
	}
	
	private void theFrame(){
		this.setTitle("NotIt");
		this.setSize(500, 400); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		
		/**
		 * JLabel
		 */
		this.addNoteButton = new JButton("Add new note");
		this.titleLabel = new JLabel("Title :");
		this.contentsLabel = new JLabel("Contents :");
		
		this.addNoteButton.setPreferredSize(new Dimension(500, 40));
		this.titleLabel.setPreferredSize(new DimensionUIResource(500, 20));
		this.contentsLabel.setPreferredSize(new Dimension(500, 20));
		
		/**
		 * JTextField
		 */
		this.titleText = new JTextField("The title of your 'Not'it'", 30);
		this.contentsText = new JTextField("Write here ...");
		
		this.titleText.setPreferredSize(new DimensionUIResource(500, 20));
		this.contentsText.setPreferredSize(new Dimension(500, 270));

		/**
		 * JSplitPane
		 */
		this.titleSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.titleLabel, this.titleText);
		this.contentsSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.contentsLabel, this.contentsText);
		this.titleSplitPane.setDividerSize(0);
		this.contentsSplitPane.setDividerSize(0);
				
		this.add(titleSplitPane, BorderLayout.PAGE_START);
		this.add(contentsSplitPane, BorderLayout.CENTER);
		this.add(addNoteButton, BorderLayout.PAGE_END);
	}
}
