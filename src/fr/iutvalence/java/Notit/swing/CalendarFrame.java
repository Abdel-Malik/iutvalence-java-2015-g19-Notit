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

import fr.iutvalence.java.Notit.Date;

public class CalendarFrame extends JFrame{

	public CalendarFrame() throws IOException{
		
		this.setTitle("NotIt");
		this.setSize(1024, 768); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		/**
		 * the JButton
		 */
		JButton homePagebutton = new JButton("to HomePage");
		homePagebutton.setPreferredSize(new Dimension(1024,68));
		homePagebutton.setBackground(Color.RED);
		
		/**
		 * the JLabel
		 */
		JLabel monthOfYear = new JLabel("Year "+ new Date().get(Date.YEAR), JLabel.CENTER); 
		monthOfYear.setPreferredSize(new Dimension(1024,50));
		/**
		 * the Panel of button
		 */
		JPanel panelOfMonthButton = new JPanel();
		panelOfMonthButton.setPreferredSize(new Dimension(1024,650));
		panelOfMonthButton.setLayout(new GridLayout(4,3));
		/**
		 * Button of month
		 */
		DateFormatSymbols monthInYear = new DateFormatSymbols(Locale.ENGLISH); // monthinYear = English date format
		String[] theMonth = monthInYear.getMonths(); // theMonth = different moth in the year in English
		for(int month=0; month<12; month++){
			panelOfMonthButton.add(new JButton(theMonth[month]));
		}
		
		this.add(homePagebutton, BorderLayout.PAGE_START);
		this.add(monthOfYear, BorderLayout.CENTER);
		this.add(panelOfMonthButton, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}
}
