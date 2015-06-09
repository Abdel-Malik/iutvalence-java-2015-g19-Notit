package fr.iutvalence.java.Notit.swing;


import java.io.IOException;

import javax.swing.JFrame;

import fr.iutvalence.java.Notit.Application;

public class MainFrame extends JFrame{

	private HomePagePanel homePage;
	private CalendarPanel calendarPanel;
	private Application application;

	public MainFrame() throws IOException{

		this.application = new Application();
		this.setTitle("NotIt");
		this.setSize(1037, 820);
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.calendarPanel = new CalendarPanel(this);
		this.homePage = new HomePagePanel(this, this.application);
		this.getContentPane().add(this.homePage);

		this.setVisible(true);
	}

	public CalendarPanel getCalendarPanel() {
		return calendarPanel;
	}

	public HomePagePanel getHomePage() {
		return homePage;
	}
	
	public Application getApplication() {
		return application;
	}


}
