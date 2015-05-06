package fr.iutvalence.java.Notit;

/**
 * The description of a date (year, month, day).
 * @author G19
 */

public class Date {
	
	/** The year. */
	private final int year;
	
	/** The month. */
	private final int month;
	
	/** The day. */
	private final int day;
	
	/**
	 * The constructor of the class Date.
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;	
	}

	/**
	 * To get the year.
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * To get the month.
	 * @return month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * To get the day.
	 * @return day
	 */
	public int getDay() {
		return day;
	}
}

