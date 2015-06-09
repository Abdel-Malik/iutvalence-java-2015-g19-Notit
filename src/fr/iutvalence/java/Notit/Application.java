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
	
	public void editDayNotes(DayNote dayNote, String title, String content) throws IOException{
		dayNote.setTitle(title);
		dayNote.setContent(content);
		dayNote.editNote();
	}
	
	public void createDayNotes(String title, String content, Date date) throws IOException{
		String path = "Notes/"+date.getDate();
		editDayNotes(new DayNote(Path.maxFileInPath(path), title, content, date), title, content);
	}

	
	public void editGNotes(GeneralNote generalNote, String title, String content) throws IOException{
		generalNote.setTitle(title);
		generalNote.setContent(content);
		generalNote.editNote();
	}
	
	public void createGNotes(String title, String content) throws IOException{
		String path = "GeneralNotes";
		editGNotes(new GeneralNote(Path.maxFileInPath(path), title, content), title, content);
	}
	
	public void deleteDayNotes(DayNote dayNote) throws IOException{
		dayNote.deleteNote();
	}
	
	public void deleteGNotes(GeneralNote generalNote) throws IOException{
		generalNote.deleteNote();
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
