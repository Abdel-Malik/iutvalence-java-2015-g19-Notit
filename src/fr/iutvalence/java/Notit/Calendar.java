package fr.iutvalence.java.Notit;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * The calendar.
 * @author G19
 */

public class Calendar {
	
	private Set<Date> listOfDateForAMonth;
	
	public Calendar(int month, int year){
		this.listOfDateForAMonth = listOfDateForAMonth(month, year);
	}

	public Set<Date> listOfDateForAMonth(int month, int year){
		Date firstDayOfMonth = new Date(year, month, 1);
		int nbDaysInMonth = 0;
		if (month == 2){
			nbDaysInMonth = firstDayOfMonth.isLeapYear(year) ? 29 : 28;
		} else{
			nbDaysInMonth = firstDayOfMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		}
	    int nbDay = 1;
	    HashSet<Date> listOfDays = new HashSet<Date>();
	    while(nbDay <= nbDaysInMonth){
	    	listOfDays.add(new Date(year, month, nbDay));
	    	nbDay++;
	    }
		return listOfDays;
	}

	public Set<Date> getListOfDateForAMonth()
	{
		return listOfDateForAMonth;
	}

	public void setListOfDateForAMonth(int month, int year)
	{
		this.listOfDateForAMonth = listOfDateForAMonth(month, year);
	}
	
	public String toString(){
		final StringBuilder result = new StringBuilder();
		for (Date date : listOfDateForAMonth)
		{				
			result.append(date);
			result.append("\n");
		}
		return result.toString();
	}
}
