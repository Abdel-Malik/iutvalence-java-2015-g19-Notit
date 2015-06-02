package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.Notit.Date;

public class MonthFrame extends JFrame{

	public MonthFrame() throws IOException{
		
		this.setTitle("NotIt");
		this.setSize(1024, 768); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		/**
		 * the JButton
		 */
		JButton homePagebutton = new JButton("to Calendar");
		homePagebutton.setPreferredSize(new Dimension(1024,68));
		homePagebutton.setBackground(Color.RED);
		
		/**
		 * the JLabel
		 */
		DateFormatSymbols elementInYear = new DateFormatSymbols(Locale.ENGLISH); // elementInYear = English date format
		String[] theMonth = elementInYear.getMonths(); // theMonth = different moth in the year in English
		String alphaMonth = theMonth[new Date().get(Date.MONTH)];
		
		JLabel monthOfYear = new JLabel(alphaMonth+" "+ new Date().get(Date.YEAR), JLabel.CENTER);
		JPanel daysPanel = new JPanel(new GridLayout(1,7));
		
		
		monthOfYear.setMinimumSize(new Dimension(1024,50));
		daysPanel.setPreferredSize(new Dimension(1024,50));
		
		daysPanel.setLayout(new GridLayout(1,7));
		
 
		String[]  alphaDay = elementInYear.getWeekdays(); // alphaDay = different day in English
		for(int day=1; day<=7; day++){
			JLabel theDay = new JLabel(alphaDay[day], JLabel.CENTER);
			theDay.setPreferredSize(new Dimension(150,50));
			daysPanel.add(theDay);
		}

				
		
		/**
		 * SplitPane for Label
		 */
		JSplitPane twoLabel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, monthOfYear, daysPanel);
		twoLabel.setDividerSize(0);
		
		/**
		 * the Panel of button
		 */
		JPanel panelOfDaysButton = new JPanel();
		panelOfDaysButton.setPreferredSize(new Dimension(1024,600));
		panelOfDaysButton.setLayout(new GridLayout(6,7));
		
		for(int numberDay=0; numberDay<42; numberDay++){
			panelOfDaysButton.add(new JButton());
		}
		
		
		/**
		 * Button of moth
		 */


		
		this.add(homePagebutton, BorderLayout.PAGE_START);
		this.add(twoLabel, BorderLayout.CENTER);
		this.add(panelOfDaysButton, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}
	
}
