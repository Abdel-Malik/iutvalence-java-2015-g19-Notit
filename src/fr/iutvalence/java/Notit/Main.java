package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.Set;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		// 0: January, 11:December 
		Calendar calendar = new Calendar(0, 2015);
		System.out.println(calendar);
		
		Set<GeneralNote> listGeneralNote = new NoteList().getlistOfGeneralNote();
		for(GeneralNote note : listGeneralNote){
			System.out.println(note);
		}
	}

}
