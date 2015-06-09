package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.Notit.Date;
import fr.iutvalence.java.Notit.DayNote;

public class DayPanel extends JPanel implements ActionListener{

	private MainFrame theFrame;
	private JButton toMonthButton;
	private JButton addDayNoteButton;
	private JLabel noteLabel;
	private JPanel notePanel;
	private JSplitPane noteSplit;
	private MonthPanel theMonthPanel;
	private NewNoteFrame note;
	private Date theDate;
	
	public DayPanel(Date theDate, MonthPanel theMonthPanel, MainFrame frame) throws IOException{

		this.theMonthPanel = theMonthPanel;
		this.theDate = theDate;
		this.theFrame = frame;
		this.setSize(1024, 768); 

		/**
		 * the Buttons.
		 */
		this.toMonthButton = new JButton("to Month");
		this.addDayNoteButton = new JButton("addDayNote");

		this.toMonthButton.setPreferredSize(new Dimension(1024,68));
		this.toMonthButton.setBackground(Color.RED);

		this.addDayNoteButton.setPreferredSize(new Dimension(200,50));
		this.addDayNoteButton.setBackground(Color.YELLOW);
		
		this.toMonthButton.addActionListener(this);
		this.addDayNoteButton.addActionListener(this);


		/**
		 *  the labels
		 */
		this.noteLabel = new JLabel("Note of "+ theDate.getEntireDate(), JLabel.CENTER);

		this.noteLabel.setPreferredSize(new Dimension(824,50));
		this.noteLabel.setBackground(Color.GREEN);

		/**
		 * the panels
		 */
		this.notePanel = new JPanel();

		this.notePanel.setBackground(Color.BLUE);
		this.notePanel.setPreferredSize(new Dimension(1024,650));


		/**
		 * SplitPane
		 */
		this.noteSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.noteLabel, this.addDayNoteButton);

		this.noteSplit.setDividerSize(0);


		this.add(toMonthButton, BorderLayout.PAGE_START);
		this.add(noteSplit, BorderLayout.CENTER);
		this.add(notePanel, BorderLayout.PAGE_END);
		
		this.displayDayNotePanel();
		
		this.setVisible(true);
	}
	
	public void displayDayNotePanel() throws IOException{
		this.setVisible(false);
		this.notePanel.removeAll();
		this.theDate.updateListOfNote();
		for(DayNote dayNote : this.theDate.getListOfNote()){
			this.notePanel.add(new NotePanel(dayNote, this, this.theFrame));
		}
		this.notePanel.revalidate();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
		if(e.getSource()== this.toMonthButton){
			this.theFrame.setContentPane(this.theMonthPanel);
			this.theFrame.revalidate();
		}
		if(e.getSource()==this.addDayNoteButton){
			this.note = new NewNoteFrame(this.theDate, this, this.theFrame);
		}
		
	}
}
