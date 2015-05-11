package fr.iutvalence.java.Notit;

/**
 * Note of the day.
 * @author G19
 */
public class DayNote extends Note{
	
	Date date;

	public DayNote(int number, String title, String content, Date date) {
		super(number, title, content);
		this.date = date;

	}

}
