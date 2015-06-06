package fr.iutvalence.java.Notit.swing;


import java.io.IOException;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private HomePagePanel homePage;
	private CalendarPanel calendarPanel;
	private MonthPanel monthPanel;

	public MainFrame() throws IOException{

		this.setTitle("NotIt");
		this.setSize(1037, 820);
		this.setResizable(false); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		
		this.calendarPanel = new CalendarPanel(this);
		this.homePage = new HomePagePanel(this);
		this.getContentPane().add(this.homePage);

		this.setVisible(true);
	}

	public CalendarPanel getCalendarFrame() {
		return calendarPanel;
	}

	public HomePagePanel getHomePage() {
		return homePage;
	}
	
	public MonthPanel getMonthPanel(){
		return monthPanel;
	}
	
	

}
