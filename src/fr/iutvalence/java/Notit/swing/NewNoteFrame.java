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

public class NewNoteFrame extends JFrame{

	private JButton addNoteLabel;
	private JLabel title;
	private JLabel contents;
	private JTextField titleText;
	private JTextField contentsText;
	private JSplitPane titleSplitPane;
	private JSplitPane contentsSplitPane;
	
	public NewNoteFrame(){


		this.setTitle("NotIt");
		this.setSize(500, 400); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
		/**
		 * JLabel
		 */
		this.addNoteLabel = new JButton("Add new note");
		this.title = new JLabel("Title :");
		this.contents = new JLabel("Contents :");
		
		this.addNoteLabel.setPreferredSize(new Dimension(500, 40));
		this.title.setPreferredSize(new DimensionUIResource(500, 20));
		this.contents.setPreferredSize(new Dimension(500, 20));
		
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
		this.titleSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.title, this.titleText);
		this.contentsSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.contents, this.contentsText);
		this.titleSplitPane.setDividerSize(0);
		this.contentsSplitPane.setDividerSize(0);
				
		this.add(titleSplitPane, BorderLayout.PAGE_START);
		this.add(contentsSplitPane, BorderLayout.CENTER);
		this.add(addNoteLabel, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}
}
