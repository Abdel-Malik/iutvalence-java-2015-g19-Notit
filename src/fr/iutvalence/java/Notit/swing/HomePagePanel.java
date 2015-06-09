package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import fr.iutvalence.java.Notit.Application;
import fr.iutvalence.java.Notit.Date;
import fr.iutvalence.java.Notit.DayNote;
import fr.iutvalence.java.Notit.GeneralNote;

public class HomePagePanel extends JPanel implements ActionListener{

	/**
	 * Constructor of the typical frame.
	 * @throws IOException 
	 */
	private MainFrame theFrame;
	
	private JButton toCalendarButton;
	private JButton addGeneralNoteButton;
	private JButton addDayNoteButton;
	private JLabel firstLabel;
	private JLabel secondLabel;
	private JPanel generalNotePanel;
	private JPanel dayNotePanel;
	private JSplitPane generalNoteSplit;
	private JSplitPane dayNoteSplit;
	private JSplitPane allGeneral;
	private JSplitPane allDay;
	private NewNoteFrame note;
	private Application application;
	
	public HomePagePanel(MainFrame frame, Application application) throws IOException{
		
		  Dimension buttonDimension = new Dimension(200,50);
		  Dimension labelDimension = new Dimension(824,50);
		  Dimension panelDimension = new Dimension(1024,300);
		  
		  this.application = application;
		  this.theFrame = frame;
		
		  this.setSize(1024, 768); 

		  /**
		   * the Buttons.
		   */
		  this.toCalendarButton = new JButton("Calendar");
		  this.addGeneralNoteButton = new JButton("addGeneralNote");
		  this.addDayNoteButton = new JButton("addDayNote");
		  
		  this.toCalendarButton.setPreferredSize(new Dimension(1024,68));
		  this.toCalendarButton.setBackground(Color.RED);

		  this.addGeneralNoteButton.setPreferredSize(buttonDimension);
		  this.addGeneralNoteButton.setBackground(Color.YELLOW);

		  this.addDayNoteButton.setPreferredSize(buttonDimension);
		  this.addDayNoteButton.setBackground(Color.YELLOW);
		  
		  this.toCalendarButton.addActionListener(this);
		  this.addGeneralNoteButton.addActionListener(this);
		  this.addDayNoteButton.addActionListener(this);
		  
		  /**
		   *  the labels
		   */
		  this.firstLabel = new JLabel("General Note");

		
		  Date date = new Date();
		  String currentDay = date.getEntireDate();
		  this.secondLabel = new JLabel("Note of "+ currentDay);

		  this.firstLabel.setMinimumSize(labelDimension);
		  this.firstLabel.setBackground(Color.GREEN);
		  this.secondLabel.setMinimumSize(labelDimension);
		  this.secondLabel.setBackground(Color.GREEN);
		  
		  /**
		   * the panels
		   */
		  this.generalNotePanel = new JPanel();
		  this.dayNotePanel = new JPanel();
		  
		  this.generalNotePanel.setBackground(Color.BLUE);
		  this.dayNotePanel.setBackground(Color.BLUE);
		  this.generalNotePanel.setPreferredSize(panelDimension);
		  this.dayNotePanel.setPreferredSize(panelDimension);

		  
		  /**
		   * SplitPane
		   */
		  this.generalNoteSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, firstLabel, addGeneralNoteButton);
		  this.dayNoteSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, secondLabel, addDayNoteButton);
		  this.allGeneral = new JSplitPane(JSplitPane.VERTICAL_SPLIT, generalNoteSplit, generalNotePanel);
		  this.allDay = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dayNoteSplit, dayNotePanel);
		  
		  this.generalNoteSplit.setDividerSize(0);
		  this.dayNoteSplit.setDividerSize(0);
		  this.allGeneral.setDividerSize(0);
		  this.allDay.setDividerSize(0); 

		  this.add(toCalendarButton, BorderLayout.PAGE_START);
		  this.add(allGeneral, BorderLayout.CENTER);
		  this.add(allDay, BorderLayout.PAGE_END);

		  this.displayGeneralNote();
		  this.displayDayNote();

	}

	
	public void displayGeneralNote() throws IOException{
		this.setVisible(false);
		this.generalNotePanel.removeAll();
		for(GeneralNote generalNote : this.application.getGeneralNote()){
			this.generalNotePanel.add(new NotePanel(generalNote, this.theFrame));
		}
		this.generalNotePanel.revalidate();
		this.setVisible(true);
	}


	
	public void displayDayNote() throws IOException{
		this.setVisible(false);
		this.dayNotePanel.removeAll();
		for(DayNote dayNote : this.application.getDayNote()){
			this.dayNotePanel.add(new NotePanel(dayNote, this.theFrame));
		}
		this.dayNotePanel.revalidate();
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()== this.toCalendarButton){
			this.theFrame.setContentPane(this.theFrame.getCalendarPanel());
			this.theFrame.revalidate();
		}
		
		if(e.getSource()==this.addGeneralNoteButton){
			this.note = new NewNoteFrame(this.theFrame);
		}
		
		if(e.getSource()==this.addDayNoteButton){
			try {
				this.note = new NewNoteFrame(new Date(), this.theFrame);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
