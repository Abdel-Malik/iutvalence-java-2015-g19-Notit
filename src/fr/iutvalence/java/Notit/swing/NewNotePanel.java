package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class NewNotePanel extends JPanel{
	
	private JLabel noteName;
	private JLabel descriptionNote;
	private JButton deleteNote;
	private JButton editNote;
	private JSplitPane buttonSplit;
	private JSplitPane labelSplit;
	
	public NewNotePanel(){
		
		this.setPreferredSize(new Dimension(100, 50));
		
		/**
		 * JLabel
		 */
		this.noteName = new JLabel("name");
		this.descriptionNote = new JLabel("desription");
		
		//this.noteName.preferredSize(new Dimension());
		
		/**
		 * JButton
		 */
		this.deleteNote = new JButton("delete");
		this.editNote = new JButton("edit");
		
		/**
		 * JSplitPane
		 */
		this.buttonSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, deleteNote, editNote);
		this.labelSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, noteName, descriptionNote);
		
		this.buttonSplit.setDividerSize(0);
		this.labelSplit.setDividerSize(0);
		
		
		this.add(buttonSplit, BorderLayout.LINE_START);
		this.add(labelSplit, BorderLayout.LINE_END);
		
		
	}

}
