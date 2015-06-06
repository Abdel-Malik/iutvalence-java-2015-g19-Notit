package fr.iutvalence.java.Notit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Note of the day.
 * 
 * @author G19
 */
public class DayNote extends Note
{
	Date date;

	/**
	 * DayNote's constructor.
	 * 
	 * @param number
	 * @param title
	 * @param content
	 * @param date
	 */
	public DayNote(int number, String title, String content, Date date)
	{
		super(number, title, content);
		this.date = date;
	}
	

	public void EditNote() throws IOException {
		File file = null;
		FileWriter write = null;
		String path = "Notes/"+this.date.getDate();
		if (!Path.checkPath(path)){
			Path.createPath(path);
	 		file = new File(path+"/"+1);
	 		file.createNewFile();
	 		write = new FileWriter(file);
		}
		else{
			file = new File(path+"/"+this.number);
	 		write = new FileWriter(file);
		}
		write.write(this.number+"\n"+this.title+"\n"+this.content);
		write.close();
	 }
	
	public void deleteNote(){
		String path = "Notes/"+this.date.getDate()+"/"+this.number;
		if(Path.checkPath(path)){
			File file = new File(path);
			file.delete();
		}
	}
}
