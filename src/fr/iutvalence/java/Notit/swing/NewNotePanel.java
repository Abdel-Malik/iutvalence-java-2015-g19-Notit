package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.nio.charset.Charset;

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
	
	public NewNotePanel(int idNote, String name, String content){
		
		Dimension dimForButton = new Dimension(70, 30);
		Dimension dimForLabel = new Dimension(150,30);
		
		this.setPreferredSize(new Dimension(250, 75));
		
		/**
		 * JLabel
		 */
		this.noteName = new JLabel(name);
		this.noteName.setPreferredSize(dimForLabel);
		this.descriptionNote = new JLabel(content);
		this.descriptionNote.setPreferredSize(dimForLabel);
		
		/**
		 * JButton
		 */
		this.deleteNote = new JButton("delete");
		this.deleteNote.setPreferredSize(dimForButton);
		this.editNote = new JButton("edit");
		this.editNote.setPreferredSize(dimForButton);
		
		/**
		 * JSplitPane
		 */
		this.buttonSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, deleteNote, editNote);
		this.labelSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, noteName, descriptionNote);	
		
		this.buttonSplit.setDividerSize(0);
		this.labelSplit.setDividerSize(0);
		
		this.add(buttonSplit, BorderLayout.WEST);
		this.add(labelSplit, BorderLayout.EAST);
		
		
	}

}
