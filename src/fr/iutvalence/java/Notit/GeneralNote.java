package fr.iutvalence.java.Notit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The note you have to do but without deadline.
 * @author G19
 */
public class GeneralNote extends Note{
/**
 * GeneralNote's constructor 
 * @param number
 * @param title
 * @param content
 */
	public GeneralNote(int number, String title, String content) {
		super(number, title, content);
		// TODO Auto-generated constructor stub
	}
	

	public void editNote() throws IOException {
		File file = null;
		FileWriter write = null;
		String path = "GeneralNotes";
		if (!Path.checkPath(path))
			Path.createPath(path);
		file = new File(path+"/"+this.number);
		file.createNewFile();
 		write = new FileWriter(file);
		write.write(this.number+"\r"+this.title+"\r"+this.content);
		write.close();
	}
	
	public void deleteNote(){
		String path = "GeneralNotes"+"/"+this.number;
		if(Path.checkPath(path)){
			File file = new File(path);
			file.delete();
		}
	}
}
