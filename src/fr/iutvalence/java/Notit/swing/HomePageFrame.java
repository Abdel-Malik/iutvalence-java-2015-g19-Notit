package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.Notit.Date;

public class HomePageFrame extends JPanel implements ActionListener{

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
	
	public HomePageFrame(MainFrame frame) throws IOException{
		
		  Dimension buttonDimension = new Dimension(200,50);
		  Dimension labelDimension = new Dimension(824,50);
		  Dimension panelDimension = new Dimension(1024,300);
		  
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
		  
		  /**
		   *  the labels
		   */
		  this.firstLabel = new JLabel("General Note");
		  this.secondLabel = new JLabel("Note of "+ new Date());
		  
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
		  
		  this.setVisible(true);
	}
	
	public JButton getToCalendarButton() {
		return toCalendarButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()== this.toCalendarButton){
			this.theFrame.setContentPane(this.theFrame.getCalendarFrame());
			this.theFrame.revalidate();
		}
		
	}




}
