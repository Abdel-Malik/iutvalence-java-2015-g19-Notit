package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.Set;

import fr.iutvalence.java.Notit.swing.CalendarFrame;
import fr.iutvalence.java.Notit.swing.DayFrame;
import fr.iutvalence.java.Notit.swing.HomePageFrame;
import fr.iutvalence.java.Notit.swing.MainFrame;
import fr.iutvalence.java.Notit.swing.MonthFrame;


public class Main
{

	public static void main(String[] args) throws IOException
	{
		
		MainFrame intermarche = new MainFrame();
		// 0: January, 11:December 
		Calendar calendar = new Calendar(5, 2015);
		System.out.println(calendar);
			
		Set<GeneralNote> listGeneralNote = new NoteList().getlistOfGeneralNote();
		for(GeneralNote note : listGeneralNote){
			System.out.println(note);
		}
	}

}
