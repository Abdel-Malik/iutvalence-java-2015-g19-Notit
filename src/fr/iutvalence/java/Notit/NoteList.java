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
		HashSet<GeneralNote> listOfGeneralNote = new HashSet<GeneralNote>();
		File[] files = arrayOfNote(true);
		for(int index =0; index < files.length ; index++){
			FileReader flux = new FileReader(files[index]);
			int lettre;
			while ((lettre = flux.read()) != 13){
				numTemp += (char)(lettre);
			}
			numero = Integer.parseInt(numTemp);
			while((lettre = flux.read()) != 13){
				title += lettre;
			}
			while((lettre = flux.read()) != -1){
				contenu += lettre;
			}
			this.listOfGeneralNote.add(new GeneralNote(numero,title,contenu));
		}
	}
	
	public NoteList(Date date) throws IOException{
		String numTemp = "";
		int numero = 0;
		String title = "";
		String contenu = "";
		HashSet listOfDayNote = new HashSet<GeneralNote>();
		File[] files = arrayOfNote(false);
		for(int index =0; index < files.length ; index++){
			FileReader flux = new FileReader(files[index]);
			int lettre;
			while ((lettre = flux.read()) != 13){
				numTemp += (char)(lettre);
			}
			numero = Integer.parseInt(numTemp);
			while((lettre = flux.read()) != 13){
				title += lettre;
			}
			while((lettre = flux.read()) != -1){
				contenu += lettre;
			}
			listOfGeneralNote.add(new GeneralNote(numero,title,contenu));
		}
	}
	
	private File[] arrayOfNote(boolean b){
		File[] files = null;
		if (b){
			File repertoire = new File("Not'it/GeneralNotes");
			files = repertoire.listFiles();
		}
		else{
			File repertoire = new File("Not'it/Notes");
			files = repertoire.listFiles();
		}
		return files;
	}
	
	public Set<GeneralNote> getlistOfGeneralNote(){
		return this.listOfGeneralNote;
	}
}