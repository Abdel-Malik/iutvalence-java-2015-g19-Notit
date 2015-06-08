package fr.iutvalence.java.Notit;

import java.io.IOException;

/**
 * The application.
 * @author G19
 */
public class Application {
	
	
	public void editDayNotes(int number, String title, String content, Date date) throws IOException{
		DayNote theNote = new DayNote(number, title, content, date);
		theNote.setTitle(title);
		theNote.setContent(content);
		theNote.editNote();
	}
	
	public void editDayNotes(String title, String content, Date date) throws IOException{
		String path = "Notes/"+date.getDate();
		editDayNotes(Path.maxFileInPath(path), title, content, date);
	}

	
	public void editGNotes(int number, String title, String content) throws IOException{
		GeneralNote theNote = new GeneralNote(number, title, content);
		theNote.setTitle(title);
		theNote.setContent(content);
		theNote.editNote();
	}
	
	public void editGNotes(String title, String content) throws IOException{
		String path = "GeneralNotes";
		editGNotes(Path.maxFileInPath(path), title, content);
	}

}
