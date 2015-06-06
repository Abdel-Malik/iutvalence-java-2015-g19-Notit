package fr.iutvalence.java.Notit;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The class calendar.
 * 
 * @author G19
 */

public class Calendar
{
	/**
	 * The list of date for a month.
	 */
	private Set<Date> listOfDateForAMonth;

	/**
	 * The Calendar's constructor.
	 * 
	 * @param month
	 * @param year
	 * @throws IOException
	 */
	public Calendar(int month, int year) throws IOException
	{
		this.listOfDateForAMonth = listOfDateForAMonth(month, year);
	}

	/**
	 * Return a list of days for a month and a year given.
	 * 
	 * @param month
	 * @param year
	 * @return listOfDays
	 * @throws IOException
	 */
	public Set<Date> listOfDateForAMonth(int month, int year)
			throws IOException
	{
		Date firstDayOfMonth = new Date(year, month, 1);
		int nbDaysInMonth = 0;
		if (month == 2)
		{
			nbDaysInMonth = firstDayOfMonth.isLeapYear(year) ? 29 : 28;
		} else
		{
			nbDaysInMonth = firstDayOfMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		}
		int nbDay = 1;
		SortedSet<Date> listOfDays = new TreeSet<Date>();
		while (nbDay <= nbDaysInMonth)
		{
			listOfDays.add(new Date(year, month, nbDay));
			nbDay++;
		}
		return listOfDays;
	}

	/**
	 * Getter to get list of date for a month.
	 * 
	 * @return listOfDateForAMonth
	 */
	public Set<Date> getListOfDateForAMonth()
	{
		return listOfDateForAMonth;
	}

	/**
	 * Setter to set list of date for a month.
	 * 
	 * @param month
	 * @param year
	 * @throws IOException
	 */
	public void setListOfDateForAMonth(int month, int year) throws IOException
	{
		this.listOfDateForAMonth = listOfDateForAMonth(month, year);
	}

	/**
	 * Displays the list of date for a month.
	 */
	public String toString()
	{
		final StringBuilder result = new StringBuilder();
		for (Date date : listOfDateForAMonth)
		{
			result.append(date);
			result.append("\n");
		}
		return result.toString();
	}
}
