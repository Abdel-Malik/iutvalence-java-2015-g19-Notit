package fr.iutvalence.java.Notit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class NoteList {
	private Set<DayNote> listOfDayNote;
	private Set<GeneralNote> listOfGeneralNote;
	
	public NoteList() throws IOException{
		String numTemp = "";
		int numero = 0;
		String title = "";
		String contenu = "";
		this.listOfGeneralNote = new HashSet<GeneralNote>();
		File[] files = arrayOfNote(true);
		
		for(int index = 0; index < files.length ; index++){
			numTemp = "";
			numero = 0;
			title = "";
			contenu = "";
			FileReader flux = new FileReader(files[index]);
			int lettre;
			while ((lettre = flux.read()) != 13){
				numTemp += (char)lettre;
			}
			numero = Integer.parseInt(numTemp);
			while((lettre = flux.read()) != 13){
				title += (char)lettre;
			}
			while((lettre = flux.read()) != -1){
				contenu += (char)lettre;
			}

			this.listOfGeneralNote.add(new GeneralNote(numero,title,contenu));
		}
	}
	
	public NoteList(Date date) throws IOException{
		String numTemp = "";
		int numero = 0;
		String title = "";
		String contenu = "";
		this.listOfDayNote = new HashSet<DayNote>();
		File[] files = arrayOfNote(false);
		
		for(int index =0; index < files.length ; index++){
			numTemp = "";
			numero = 0;
			title = "";
			contenu = "";
			String name = files[index].getName();
			FileReader flux = new FileReader(files[index]);
			int lettre;
			
			while ((lettre = flux.read()) != 13){
				numTemp += (char)(lettre);
			}
			numero = Integer.parseInt(numTemp);
			while((lettre = flux.read()) != 13){
				title += (char)lettre;
			}
			while((lettre = flux.read()) != -1){
				contenu += (char)lettre;
			}
			listOfDayNote.add(new DayNote(numero,title,contenu,date));
		}
	}
	
	private File[] arrayOfNote(boolean b){
		File[] files = null;
		if (b){
			File repertoire = new File("GeneralNotes");
			files = repertoire.listFiles();
		}
		else{
			File repertoire = new File("Notes");
			files = repertoire.listFiles();
		}
		return files;
	}
	
	public Set<GeneralNote> getlistOfGeneralNote(){
		return this.listOfGeneralNote;
	}
	
	public Set<DayNote> getlistOfDayNote(){
		return this.listOfDayNote;
	}
}