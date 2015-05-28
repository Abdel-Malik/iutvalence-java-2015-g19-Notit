package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Set;

/**
 * The description of a date (year, month, day).
 * 
 * @author G19
 */

public class Date extends GregorianCalendar
{

	/**
	 * A list of note.
	 */
	private Set<DayNote> listOfNote;

	/**
	 * The Date's constructor.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public Date(int year, int month, int day) throws IOException
	{
		super(year, month, day);
		this.listOfNote = new NoteList(this).getlistOfDayNote();
	}

	/**
	 * The Date's constructor to know the date of the day.
	 */
	public Date() throws IOException
	{
		super();
		this.listOfNote = new NoteList(this).getlistOfDayNote();
	}

	/**
	 * Displays the date and the list of date attached.
	 */
	public String toString()
	{
		return this.get(DAY_OF_MONTH) + "/" + this.get(MONTH) + "/"
				+ this.get(YEAR) + " : " + this.listOfNote.size();
	}
}
