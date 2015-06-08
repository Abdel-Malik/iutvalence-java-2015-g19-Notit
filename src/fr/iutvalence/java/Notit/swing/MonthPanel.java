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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import fr.iutvalence.java.Notit.Calendar;
import fr.iutvalence.java.Notit.Date;

public class MonthPanel extends JPanel implements ActionListener{

	private MainFrame theFrame;
	private JButton homePageButton;
	private MyButton[] tableButton;
	private JLabel monthOfYear;
	private JPanel daysPanel;
	private JSplitPane twoLabel;
	private JPanel panelOfDaysButton;
	private Calendar theCalendar;
	private int currentYear;
	private int theMonth;
	private MonthPanel thisPanel;

	public MonthPanel(int numberOfMonth, MainFrame frame) throws IOException{

		this.thisPanel = this;
		this.theMonth = numberOfMonth;
		this.theFrame = frame;
		this.setSize(1024, 768); 
		this.theCalendar = new Calendar(numberOfMonth, new Date().get(Date.YEAR));

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
		this.currentYear =  new Date().get(Date.YEAR);
		this.monthOfYear = new JLabel(alphaMonth+" "+ this.currentYear, JLabel.CENTER);
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
		this.twoLabel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.monthOfYear, this.daysPanel);
		this.twoLabel.setDividerSize(0);

		/**
		 * the Panel of button
		 */
		this.panelOfDaysButton = new JPanel();
		this.panelOfDaysButton.setPreferredSize(new Dimension(1024,600));
		this.panelOfDaysButton.setLayout(new GridLayout(6,7));
		this.tableButton = new MyButton[42];
		int numberDay = 1;
		
		for(int numberCase=0; numberCase<42; numberCase++){
			if (numberCase == theCalendar.getFirstDay()-1)
			{
				this.tableButton[numberCase]=new MyButton("J"+numberDay, numberDay);
				this.tableButton[numberCase].addActionListener(this);
				this.panelOfDaysButton.add(tableButton[numberCase]);
				numberDay++;
			} 
			else if(numberCase<theCalendar.getFirstDay()-1)
			{
				this.tableButton[numberCase]=new MyButton();
				this.tableButton[numberCase].setEnabled(false);
				this.panelOfDaysButton.add(tableButton[numberCase]);
			}
			else if(numberDay>theCalendar.getListOfDateForAMonth().size())
			{
				this.tableButton[numberCase]=new MyButton();
				this.tableButton[numberCase].setEnabled(false);
				this.panelOfDaysButton.add(tableButton[numberCase]);
			}
			else {
				this.tableButton[numberCase]=new MyButton("J"+numberDay, numberDay);
				this.tableButton[numberCase].addActionListener(this);
				this.panelOfDaysButton.add(tableButton[numberCase]);
				numberDay++;
			}
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
		
		for (int x=0; x<42; x++)
			if (e.getSource() == this.tableButton[x])
			{
				try {
					Date theDate = new Date(this.currentYear, this.theMonth, this.tableButton[x].getID());
					this.theFrame.setContentPane(new DayPanel(theDate, thisPanel, this.theFrame));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.theFrame.revalidate();
			}

	}


}
