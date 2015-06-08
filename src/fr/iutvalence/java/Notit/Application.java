package fr.iutvalence.java.Notit;

/**
 * The application.
 * @author G19
 */
public class Application {
	
	
	public void editDayNotes(int number, String title, String content, Date date){
		DayNote theNote = new DayNote(number, title, content, date);
		theNote.editNote();
			theNote.setTitle(title);
			theNote.setContent(content);
		}
	
	public void editDayNotes(String title, String content, Date date){
		String path = "Notes/"+theNote.getDate().getDate();
		editNotes(Path.maxFileInPath(path), title, content, date);
	}

}
