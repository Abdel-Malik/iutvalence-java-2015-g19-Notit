package fr.iutvalence.java.Notit.swing;


import java.io.IOException;

import javax.swing.JFrame;

public class MainFrame extends JFrame{


	private HomePageFrame homePage;
	private CalendarFrame calendarFrame;
	


	public MainFrame() throws IOException{

		this.setTitle("NotIt");
		this.setSize(1037, 820); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

		this.calendarFrame = new CalendarFrame(this);
		this.homePage = new HomePageFrame(this);
		this.getContentPane().add(this.homePage);

		this.setVisible(true);
	}

	public CalendarFrame getCalendarFrame() {
		return calendarFrame;
	}

	public HomePageFrame getHomePage() {
		return homePage;
	}
	
	

}
