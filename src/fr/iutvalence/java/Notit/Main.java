package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.Set;

import fr.iutvalence.java.Notit.swing.HomePageFrame;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		
		HomePageFrame intermarche = new HomePageFrame();
		// 0: January, 11:December 
		Calendar calendar = new Calendar(0, 2015);
		System.out.println(calendar);
		
		Set<GeneralNote> listGeneralNote = new NoteList().getlistOfGeneralNote();
		for(GeneralNote note : listGeneralNote){
			System.out.println(note);
		}
	}

}