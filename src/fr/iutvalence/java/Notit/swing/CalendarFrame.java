package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutvalence.java.Notit.Date;

public class CalendarFrame extends JPanel implements ActionListener{

	private MainFrame theFrame;
	
	private JButton toHomePagebutton;
	private JLabel monthOfYear;
	private JPanel panelOfMonthButton;
	
	public CalendarFrame(MainFrame frame) throws IOException{

		this.theFrame=frame;

		this.setSize(1024, 768); 

		/**
		 * the JButton
		 */
		this.toHomePagebutton = new JButton("to HomePage");
		this.toHomePagebutton.addActionListener(this);
		this.toHomePagebutton.setPreferredSize(new Dimension(1024,68));
		this.toHomePagebutton.setBackground(Color.RED);

		/**
		 * the JLabel
		 */
		this.monthOfYear = new JLabel("Year "+ new Date().get(Date.YEAR), JLabel.CENTER); 
		this.monthOfYear.setPreferredSize(new Dimension(1024,50));
		/**
		 * the Panel of button
		 */
		this.panelOfMonthButton = new JPanel();
		this.panelOfMonthButton.setPreferredSize(new Dimension(1024,650));
		this.panelOfMonthButton.setLayout(new GridLayout(4,3));
		/**
		 * Button of month
		 */
		DateFormatSymbols monthInYear = new DateFormatSymbols(Locale.ENGLISH); // monthinYear = English date format
		String[] theMonth = monthInYear.getMonths(); // theMonth = different moth in the year in English
		for(int month=0; month<12; month++){
			this.panelOfMonthButton.add(new JButton(theMonth[month]));
		}

		this.add(toHomePagebutton, BorderLayout.PAGE_START);
		this.add(monthOfYear, BorderLayout.CENTER);
		this.add(panelOfMonthButton, BorderLayout.PAGE_END);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== this.toHomePagebutton){
			this.theFrame.setContentPane(this.theFrame.getHomePage());
			this.theFrame.revalidate();
		}
		
	}
}
