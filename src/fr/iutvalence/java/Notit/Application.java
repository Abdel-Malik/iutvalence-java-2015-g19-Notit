package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.Set;

/**
 * The application.
 * @author G19
 */
public class Application {
	
	private int currentYear;
	
	public Application() throws IOException{
		this.currentYear = new Date().get(Date.YEAR);
	}
	
	public void editDayNotes(int number, String title, String content, Date date) throws IOException{
		DayNote theNote = new DayNote(number, title, content, date);
		theNote.setTitle(title);
		theNote.setContent(content);
		theNote.editNote();
	}
	
	public void createDayNotes(String title, String content, Date date) throws IOException{
		String path = "Notes/"+date.getDate();
		editDayNotes(Path.maxFileInPath(path), title, content, date);
	}

	
	public void editGNotes(int number, String title, String content) throws IOException{
		GeneralNote theNote = new GeneralNote(number, title, content);
		theNote.setTitle(title);
		theNote.setContent(content);
		theNote.editNote();
	}
	
	public void createGNotes(String title, String content) throws IOException{
		String path = "GeneralNotes";
		editGNotes(Path.maxFileInPath(path), title, content);
	}
	
	public void deleteDayNotes(int number, String title, String content, Date date) throws IOException{
		DayNote myNote = new DayNote(number, title, content, date);
		myNote.deleteNote();
	}
	
	public void deleteGNotes(int number, String title, String content) throws IOException{
		GeneralNote myNote = new GeneralNote(number, title, content);
		myNote.deleteNote();
	}
	
	public Set<GeneralNote> getGeneralNote() throws IOException{
		return new NoteList().getlistOfGeneralNote();
	}
	
	public Set<DayNote> getDayNote() throws IOException{
		return new NoteList(new Date()).getlistOfDayNote();
	}
	
	public Calendar getCalendar(int monthNumber) throws IOException{
		return new Calendar(monthNumber, this.currentYear);
	}
}
