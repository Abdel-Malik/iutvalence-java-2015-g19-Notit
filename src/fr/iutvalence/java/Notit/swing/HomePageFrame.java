package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.Notit.Date;

public class HomePageFrame extends JFrame{

	/**
	 * Constructor of the typical frame.
	 * @throws IOException 
	 */
	public HomePageFrame() throws IOException{
		
		  Dimension buttonDimension = new Dimension(200,50);
		  Dimension labelDimension = new Dimension(824,50);
		  Dimension panelDimension = new Dimension(1024,300);
		
		  this.setTitle("NotIt");
		  this.setSize(1024, 768); 
		  this.setResizable(false); 
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		  
		  /**
		   * the Buttons.
		   */
		  JButton toCalendarButton = new JButton("Calendar");
		  JButton addGeneralNoteButton = new JButton("addGeneralNote");
		  JButton addDayNoteButton = new JButton("addDayNote");
		  
		  toCalendarButton.setPreferredSize(new Dimension(1024,68));
		  toCalendarButton.setBackground(Color.RED);

		  addGeneralNoteButton.setPreferredSize(buttonDimension);
		  addGeneralNoteButton.setBackground(Color.YELLOW);

		  addDayNoteButton.setPreferredSize(buttonDimension);
		  addDayNoteButton.setBackground(Color.YELLOW);
		  
		  /**
		   *  the labels
		   */
		  JLabel firstLabel = new JLabel("General Note");
		  JLabel secondLabel = new JLabel("Note of "+ new Date());
		  
		  firstLabel.setMinimumSize(labelDimension);
		  firstLabel.setBackground(Color.GREEN);
		  secondLabel.setMinimumSize(labelDimension);
		  secondLabel.setBackground(Color.GREEN);
		  
		  /**
		   * the panels
		   */
		  JPanel generalNotePanel = new JPanel();
		  JPanel dayNotePanel = new JPanel();
		  
		  generalNotePanel.setBackground(Color.BLUE);
		  dayNotePanel.setBackground(Color.BLUE);
		  generalNotePanel.setPreferredSize(panelDimension);
		  dayNotePanel.setPreferredSize(panelDimension);

		  
		  /**
		   * SplitPane
		   */
		  JSplitPane generalNoteSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, firstLabel, addGeneralNoteButton);
		  JSplitPane dayNoteSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, secondLabel, addDayNoteButton);
		  JSplitPane allGeneral = new JSplitPane(JSplitPane.VERTICAL_SPLIT, generalNoteSplit, generalNotePanel);
		  JSplitPane allDay = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dayNoteSplit, dayNotePanel);
		  
		  generalNoteSplit.setDividerSize(0);
		  dayNoteSplit.setDividerSize(0);
		  allGeneral.setDividerSize(0);
		  allDay.setDividerSize(0); 
		  
		  
		  
		  this.add(toCalendarButton, BorderLayout.PAGE_START);
		  this.add(allGeneral, BorderLayout.CENTER);
		  this.add(allDay, BorderLayout.PAGE_END);
		  
		  this.setVisible(true);
	}
}
