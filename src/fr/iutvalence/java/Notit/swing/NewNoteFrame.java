package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.TileObserver;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import fr.iutvalence.java.Notit.Date;
import fr.iutvalence.java.Notit.GeneralNote;
import fr.iutvalence.java.Notit.Path;

public class NewNoteFrame extends JFrame implements ActionListener{

	private MainFrame theFrame;
	private JButton addNoteButton;
	private JLabel titleLabel;
	private JLabel contentsLabel;
	private JTextField titleText;
	private JTextArea contentsText;
	private JSplitPane titleSplitPane;
	private JSplitPane contentsSplitPane;
	private Date date;
	
	public NewNoteFrame(MainFrame frame){
		displayOfFrame(frame);
	}
	
	public NewNoteFrame(Date date, MainFrame frame){
		this.date=date;
		displayOfFrame(frame);
	}
	
	private void displayOfFrame(MainFrame frame){
		this.setTitle("NotIt");
		this.setSize(500, 400); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.theFrame = frame;
		
		/**
		 * JButton
		 */
		this.addNoteButton = new JButton("Add new note");
		this.addNoteButton.addActionListener(this);
		this.addNoteButton.setPreferredSize(new Dimension(500, 40));
		/**
		 * JLabel
		 */
		
		this.titleLabel = new JLabel("Title :");
		this.contentsLabel = new JLabel("Contents :");
		
		this.titleLabel.setPreferredSize(new DimensionUIResource(500, 20));
		this.contentsLabel.setPreferredSize(new Dimension(500, 20));
		
		/**
		 * JTextField
		 */
		this.titleText = new JTextField("The title of your 'Not'it'", 30);
		this.contentsText = new JTextArea("Write here ...");
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.addNoteButton)
			if(this.date==null){
				try {
					this.theFrame.getApplication().createGNotes(this.titleText.getText(), contentsText.getText());
					this.dispose();
					this.theFrame.getHomePage().displayGeneralNote();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}
}
