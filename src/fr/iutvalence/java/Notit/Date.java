package fr.iutvalence.java.Notit;

import java.util.GregorianCalendar;
import java.util.Set;

/**
 * The description of a date (year, month, day).
 * @author G19
 */

public class Date extends GregorianCalendar{
	
	private Set<DayNote> listOfNote;
	
	public Date(int year, int month, int day){
		super(year, month, day);
	}
	
	public Date(){
		super();
		
	}
	
	public String toString(){
		return this.get(DAY_OF_MONTH)+"/"+this.get(MONTH)+"/"+this.get(YEAR)+" : "+this.listOfNote;
	}
}

