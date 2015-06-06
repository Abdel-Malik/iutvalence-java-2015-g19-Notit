package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;
import java.util.Locale;
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
	
	private String dayName;
	
	private String monthName;

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
		DateFormatSymbols formatSymbol = new DateFormatSymbols(Locale.ENGLISH); // elementInYear = English date format
		String[] daysName = formatSymbol.getWeekdays();
		this.dayName = daysName[this.DAY_OF_MONTH];
		String[] monthsName = formatSymbol.getMonths();
		this.monthName = monthsName[this.MONTH];
	}

	/**
	 * The Date's constructor to know the date of the day.
	 */
	public Date() throws IOException
	{
		super();
		this.listOfNote = new NoteList(this).getlistOfDayNote();
		DateFormatSymbols formatSymbol = new DateFormatSymbols(Locale.ENGLISH); // elementInYear = English date format
		String[] daysName = formatSymbol.getWeekdays();
		this.dayName = daysName[this.DAY_OF_MONTH];
		String[] monthsName = formatSymbol.getMonths();
		this.monthName = monthsName[this.MONTH];
	}
	
	public Set<DayNote> getListOfNote() {
		return listOfNote;
	}
	
	public String getEntireDate(){
		return this.dayName + " " + this.get(this.DAY_OF_MONTH) + " " + this.monthName + " " + this.get(this.YEAR);
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
