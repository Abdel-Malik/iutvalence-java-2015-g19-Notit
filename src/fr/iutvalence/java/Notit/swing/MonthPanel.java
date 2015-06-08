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
import javax.swing.JSplitPane;

import fr.iutvalence.java.Notit.Date;

public class MonthPanel extends JPanel implements ActionListener{

	private MainFrame theFrame;
	private JButton homePageButton;
	private JButton[] tableButton;
	private JLabel monthOfYear;
	private JPanel daysPanel;
	private JSplitPane twoLabel;
	private JPanel panelOfDaysButton;
	
	public MonthPanel(int numberOfMonth, MainFrame frame) throws IOException{

		this.theFrame = frame;
		this.setSize(1024, 768); 

		/**
		 * the JButton
		 */
		this.homePageButton = new JButton("to Calendar");
		this.homePageButton.addActionListener(this);
		this.homePageButton.setPreferredSize(new Dimension(1024,68));
		this.homePageButton.setBackground(Color.RED);

		/**
		 * the JLabel
		 */
		DateFormatSymbols elementInYear = new DateFormatSymbols(Locale.ENGLISH); // elementInYear = English date format
		String[] theMonth = elementInYear.getMonths(); // theMonth = different moth in the year in English
		String alphaMonth = theMonth[numberOfMonth];

		this.monthOfYear = new JLabel(alphaMonth+" "+ new Date().get(Date.YEAR), JLabel.CENTER);
		this.daysPanel = new JPanel(new GridLayout(1,7));


		this.monthOfYear.setMinimumSize(new Dimension(1024,50));
		this.daysPanel.setPreferredSize(new Dimension(1024,50));

		this.daysPanel.setLayout(new GridLayout(1,7));


		String[]  alphaDay = elementInYear.getWeekdays(); // alphaDay = different day in English
		for(int day=1; day<=7; day++){
			JLabel theDay = new JLabel(alphaDay[day], JLabel.CENTER);
			theDay.setPreferredSize(new Dimension(150,50));
			daysPanel.add(theDay);
		}



		/**
		 * SplitPane for Label
		 */
		this.twoLabel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, monthOfYear, daysPanel);
		this.twoLabel.setDividerSize(0);

		/**
		 * the Panel of button
		 */
		this.panelOfDaysButton = new JPanel();
		this.panelOfDaysButton.setPreferredSize(new Dimension(1024,600));
		this.panelOfDaysButton.setLayout(new GridLayout(6,7));
		this.tableButton = new JButton[42];
		
		for(int numberDay=0; numberDay<42; numberDay++){
			this.tableButton[numberDay]=new JButton();
			this.panelOfDaysButton.add(tableButton[numberDay]);
		}

		this.add(this.homePageButton, BorderLayout.PAGE_START);
		this.add(this.twoLabel, BorderLayout.CENTER);
		this.add(this.panelOfDaysButton, BorderLayout.PAGE_END);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== this.homePageButton){
			this.theFrame.setContentPane(this.theFrame.getCalendarPanel());
			this.theFrame.revalidate();
		}
		
	}

}
