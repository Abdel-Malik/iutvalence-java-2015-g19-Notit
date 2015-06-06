package fr.iutvalence.java.Notit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A Note.
 * 
 * @author G19
 */
public abstract class Note {

	/**
	 * Id of note.
	 */
	protected final int number;
	/**
	 * Title of note.
	 */
	protected String title;
	/**
	 * The content of a note.
	 */
	protected String content;

	/**
	 * Note's constructor.
	 * 
	 * @param number
	 * @param title
	 * @param content
	 */
	protected Note(int number, String title, String content) {
		this.number = number;
		this.title = title;
		this.content = content;

	}

	/**
	 * Getter to get the title of the note.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter to set the title of the note.
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Getter to get the content of the note.
	 * 
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter to set content of the note.
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * displays the id, the title and the content of a note.
	 */
	public String toString() {
		return this.number + this.title + this.content;
	}

}
