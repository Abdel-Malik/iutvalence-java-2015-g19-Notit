package fr.iutvalence.java.Notit;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * The calendar.
 * @author G19
 */

public class Calendar {
	
	private Set<GregorianCalendar> listOfDate;

	public Calendar(){
		
	}

	public Set<GregorianCalendar> ListOfDateForAMonth(int month){
		Date firstDayOfMonth = new Date(2002, month, 1);
	    int nbDaysInMonth = firstDayOfMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	    int nbDay = 1;
	    HashSet<GregorianCalendar> listOfDays = new HashSet<GregorianCalendar>();
	    while(nbDay <= nbDaysInMonth){
	    	listOfDays.add(new Date(2015, month, nbDay));
	    	nbDay++;
	    }
		return listOfDays;
	}
	
	public Set<GregorianCalendar> getListOfDate() {
		return listOfDate;
	}
}
