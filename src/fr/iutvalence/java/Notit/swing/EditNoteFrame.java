package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import fr.iutvalence.java.Notit.Date;
import fr.iutvalence.java.Notit.DayNote;
import fr.iutvalence.java.Notit.GeneralNote;

public class EditNoteFrame extends JFrame implements ActionListener{

	private MainFrame theFrame;
	private JButton editNoteButton;
	private JLabel titleLabel;
	private JLabel contentsLabel;
	private JTextField titleText;
	private JTextArea contentsText;
	private JSplitPane titleSplitPane;
	private JSplitPane contentsSplitPane;
	private Date date;
	private DayPanel panel;
	private DayNote dayNote;
	private GeneralNote generalNote;
	
	
	public EditNoteFrame(DayNote dayNote, MainFrame frame){
		
		this.dayNote = dayNote;
		/**
		 * JTextField
		 */
		this.titleText = new JTextField(this.dayNote.getTitle(), 30);
		this.contentsText = new JTextArea(this.dayNote.getContent());
		
		this.displayOfFrame(frame);

	}
	
	public EditNoteFrame(GeneralNote generalNote, MainFrame frame){
		this.generalNote = generalNote;
		/**
		 * JTextField
		 */
		this.titleText = new JTextField(this.generalNote.getTitle(), 30);
		this.contentsText = new JTextArea(this.generalNote.getContent());
		
		this.displayOfFrame(frame);
		
		
	}
	
	public EditNoteFrame(DayNote dayNote, DayPanel panel, MainFrame frame){
		
		this.dayNote = dayNote;
		this.panel = panel;
		/**
		 * JTextField
		 */
		this.titleText = new JTextField(this.dayNote.getTitle(), 30);
		this.contentsText = new JTextArea(this.dayNote.getContent());
		
		this.displayOfFrame(frame);

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
		this.editNoteButton = new JButton("Edit");
		this.editNoteButton.addActionListener(this);
		this.editNoteButton.setPreferredSize(new Dimension(500, 40));
		/**
		 * JLabel
		 */
		
		this.titleLabel = new JLabel("Title :");
		this.contentsLabel = new JLabel("Contents :");
		
		this.titleLabel.setPreferredSize(new Dimension(500, 20));
		this.contentsLabel.setPreferredSize(new Dimension(500, 20));

		/**
		 * JTextField
		 */
		this.titleText.setPreferredSize(new Dimension(500, 20));
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
		this.add(editNoteButton, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.editNoteButton)
			if(this.generalNote!=null){
				try {
					this.theFrame.getApplication().editGNotes(this.generalNote, this.titleText.getText(), this.contentsText.getText());
					this.dispose();
					this.theFrame.getHomePage().displayGeneralNote();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else{
				if(this.panel==null)
				{
					try {
						this.theFrame.getApplication().editDayNotes(this.dayNote, titleText.getText(), contentsText.getText());
						this.dispose();
						this.theFrame.getHomePage().displayDayNote();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else{
					try {
						this.theFrame.getApplication().editDayNotes(this.dayNote, titleText.getText(), contentsText.getText());
						this.dispose();
						this.panel.displayDayNotePanel();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
	}

}
