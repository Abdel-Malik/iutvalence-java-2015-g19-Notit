package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.Set;
import fr.iutvalence.java.Notit.swing.MainFrame;


public class Main
{

	public static void main(String[] args) throws IOException
	{	
		MainFrame intermarche = new MainFrame();
		// 0: January, 11:December 
		Calendar calendar = new Calendar(5, 2015);
		System.out.println(calendar);
		for(Date date : calendar.getListOfDateForAMonth()){
			if (date.getListOfNote().size() != 0){
				for(Note note : date.getListOfNote()){
					System.out.println(note);
				}
			}
		}
		
		/*Set<GeneralNote> listGeneralNote = new NoteList().getlistOfGeneralNote();
		for(GeneralNote note : listGeneralNote){
			System.out.println(note);
		}*/
		
		Date date = new Date(2015, 5, 26);
		DayNote maNote = new DayNote(1, "coucou", "essai modif editNote", date);
		
		System.out.println(date.get(Date.DAY_OF_WEEK));
		maNote.deleteNote();
	}

}
