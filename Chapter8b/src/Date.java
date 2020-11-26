/* Mario Rodriguez, CS 210
 * November 27, 2020
 * Bellevue College
 * Coding Assignment 8b - Date Class
 * Requirements:
 * 1.  Do not use any imports from the JAVA API, nor any package statements, nor System.
 * 2.  I also insist the fields of your Class must remain private access.
 * 3.  Add a default constructor that initializes the default Date() to January 1, 1970
 * 4.  Notice in the text how the toString() output is always 10 characters, like 1970/01/01
 * 5.  Whenever an illegal date is attempted, your code throws an IllegalArgumentException.
 * 6.  The addDays and addWeeks methods can actually subtract days or weeks for a negative parameter passed.
 *     Test these for thousands of days too.
 * 7.  Add mutator methods (setYear, setMonth, setDay) and be certain they create valid dates,
 *     else throw the IllegalArgumentException
 * 8.  Add a longDate() method that returns a String with the format as shown below.
 * 9.  Create a static version of daysTo, used as shown in test code below.
 *     And this is the ONLY place that static appears in your Date Class.
 * 10. Reuse:  Avoid copy/paste of code (certainly no plagiarism) by using one method to call others in your Class,
 *     like only one section of "daysTo" algorithm, one general constructor called by the default, and one date
 *     verification algorithm that is used by many methods to keep the date valid.
 */

public class Date {

    private int year;
    private int month;
    private int day;

    // Default constructor for no given parameters
    public Date() {
        setYear(1970);
        setMonth(1);
        setDay(1);
    }

    // Constructs Date object with the given parameters
     public Date(int year, int month, int day) {
         setYear(year);
         setMonth(month);
         setDay(day);
    }

    public void addDays(int days) {
        //Moves this Date object forward in time by number of days.  Make sure to adjust date fields appropriately.
    }

    public void addWeeks(int weeks) {
        //Moves this Date object forward in time by the given number of seven day weeks. Make sure to adjust date fields appropriately.
    }

    public static int daysTo(Date date1, Date date2) {
        //Returns the number of days that this Date object must be adjusted to make it equal to the given other Date.
        return 2;
    }

    public int daysTo(Date other) {
        return 2;
    }

    public int getDay() {
        //Returns the date value of this date; example: for the date 2006/07/22, returns 22;
        return this.day;
    }

    public int getMonth() {
        //Returns the month value of this date; example: for the date 2006/07/22, returns 7;
        return this.month;
    }

    public int getYear() {
        //Returns the year value of this date; example: for the date 2006/07/22, returns 2006;
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.year = month;
    }

    public void setDay(int day) {
        this.year = day;
    }

    public boolean isLeapYear() {

        boolean leap = false;

        // if the year is divided by 4
        if (year % 4 == 0) {

            // if the year is century
            if (year % 100 == 0) {

                // if year is divided by 400
                // then it is a leap year
                if (year % 400 == 0) {
                    leap = true;
                }else
                    leap = false;
            } else { // if the year is not century
                leap = true;
            }
        } else {
            leap = false;
        }

        if (leap) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
        return leap;
    }

    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;
    }

    public String longDate() {
        return "The date in string ex: January 1, 1970";
    }

}
