package fr.iutvalence.java.Notit.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.Notit.Date;

public class DayPanel extends JFrame{

	public DayPanel() throws IOException{

		this.setTitle("NotIt");
		this.setSize(1024, 768); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

		/**
		 * the Buttons.
		 */
		JButton toMonthButton = new JButton("to Month");
		JButton addDayNoteButton = new JButton("addDayNote");

		toMonthButton.setPreferredSize(new Dimension(1024,68));
		toMonthButton.setBackground(Color.RED);

		addDayNoteButton.setPreferredSize(new Dimension(200,50));
		addDayNoteButton.setBackground(Color.YELLOW);


		/**
		 *  the labels
		 */
		DateFormatSymbols elementInYear = new DateFormatSymbols(Locale.ENGLISH); // elementInYear = English date format
		String[] theMonth = elementInYear.getWeekdays(); // theMonth = different moth in the year in English
		Date date = new Date();
		String currentDay = theMonth[date.get(Date.DAY_OF_MONTH)+1]+" "+ date.get(Date.DAY_OF_MONTH)+" "+ date.get(Date.YEAR);

		JLabel noteLabel = new JLabel("Note of "+ currentDay, JLabel.CENTER);

		noteLabel.setMinimumSize(new Dimension(824,50));
		noteLabel.setBackground(Color.GREEN);

		/**
		 * the panels
		 */
		JPanel notePanel = new JPanel();

		notePanel.setBackground(Color.BLUE);
		notePanel.setPreferredSize(new Dimension(1024,650));


		/**
		 * SplitPane
		 */
		JSplitPane noteSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, noteLabel, addDayNoteButton);

		noteSplit.setDividerSize(0);




		this.add(toMonthButton, BorderLayout.PAGE_START);
		this.add(noteSplit, BorderLayout.CENTER);
		this.add(notePanel, BorderLayout.PAGE_END);

		this.setVisible(true);
	}
}
