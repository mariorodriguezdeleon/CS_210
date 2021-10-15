/* Mario Rodriguez, CS 210
 * November 27, 2020
 * Bellevue College
 * Coding Assignment 8b - Date Class (from 1582 - 3000)
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
    private int daysInMonth;
    private String monthName;

    // Constructors ==============================================

    // Default constructor sets the date to January 1, 1970
    public Date() {

        this.setYear(1970);
        this.setMonth(1);
        this.setDay(1);
        this.setupDateData();

    }

    // Constructs Date object with the given Year/Month/Day parameters. Throws IllegalArgumentException
     public Date(int year, int month, int day) throws IllegalArgumentException {

        boolean dataValidates = validateData (year, month, day);

         if (dataValidates) {
             this.setYear(year);
             this.setMonth(month);
             this.setDay(day);
             this.setupDateData();
         } else {
             throw new IllegalArgumentException();
         }

     }

    // Accessors =================================================

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isLeapYear() {
        return this.isLeapYear(this.year);
    }

    // Mutators ==================================================

    public void setYear(int year) throws IllegalArgumentException {

        if (validateData(year, 1, 1)) {
            this.year = year;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void setMonth(int month) throws IllegalArgumentException {

        if (validateData(1582, month, 1)) {
            this.month = month;
            this.setMonthName(month);
            this.setDaysInMonth(month);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void setDay(int day) throws IllegalArgumentException {

        if (validateData(1582, 1, day)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void addDays(int days) {

        int newMonth = this.month;
        int newYear = this.year;

        if (days + this.day <= this.daysInMonth && days + this.day >= 1) { //within the month

            this.setDay(this.day += days);

        } else if (days + this.day > this.daysInMonth && days + countDays(this.month) <= daysInYear(this.year)) { //find month after this month but before year end

            int totalNumOfDays = days + this.day;

            while (totalNumOfDays > daysInMonth(newMonth)) {
                totalNumOfDays -= daysInMonth(newMonth);
                newMonth += 1;
            }

            this.setDay(totalNumOfDays);
            this.setMonth(newMonth);

        } else if (days + this.day < 0 && days + countDays(this.month) > 0) { //find month prior to this month within the year

            int totalNumOfDays = Math.abs(days);

            while (totalNumOfDays > daysInMonth(newMonth)) {
                totalNumOfDays -= daysInMonth(newMonth);
                newMonth -= 1;
            }

            this.setDay(totalNumOfDays);
            this.setMonth(newMonth);

        } else { //find the year, month and day

            int totalNumOfDays = countDays(this.month) + days;

            if (totalNumOfDays > daysInYear(this.year)) {
                //find year after this year
                int yearDays = daysInYear(newYear);

                while (totalNumOfDays > yearDays) { //find year
                    totalNumOfDays -= yearDays;
                    newYear += 1;
                }

                newMonth = 1; //reset month to begin year

                while (totalNumOfDays > daysInMonth(newMonth)) { //find month
                    totalNumOfDays -= daysInMonth(newMonth);
                    newMonth += 1;
                }

                this.setDay(totalNumOfDays); //leftovers become day
                this.setMonth(newMonth);

            } else {
                //find year previous to this year

                totalNumOfDays = Math.abs(days);

                while (totalNumOfDays > daysInYear(newYear)) { //find previous year
                    totalNumOfDays -= daysInYear(newYear);
                    newYear -= 1;
                }

                newMonth = 1; //reset month to begin year

                while (totalNumOfDays > daysInMonth(newMonth)) { //find month
                    totalNumOfDays -= daysInMonth(newMonth);
                    newMonth += 1;
                }

                this.setDay(totalNumOfDays); //leftovers become day
                this.setMonth(newMonth);

            }
        }
    }

    public void addWeeks(int weeks) {
        addDays(weeks * 7);
    }

    private void setMonthName (int calMonth) {

        String months [] = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

<<<<<<<

=======
        this.monthName = months [calMonth - 1];

>>>>>>>
    }

    private void setDaysInMonth(int month) {

        int numOfDays = daysInMonth(month);

        if (isLeapYear(this.year) && month == 2) {
            numOfDays += 1;
        }

        this.daysInMonth = numOfDays;

    }

    // Utilities =================================================

    private boolean validateData(int year, int month, int day) {

        int maxDays = 0;

        if (isLeapYear(year) && month == 2) {
            maxDays = 29;
        } else if (!isLeapYear(year) && month == 2) {
            maxDays = 28;
        } else if (month == 2 || month == 4 || month == 6 || month == 9 ||month == 11) {
            maxDays = 30;
        } else {
            maxDays = 31;
        }

        boolean yearValid = year >= 1582 && year <= 3000;
        boolean monthValid = month > 0 && month <= 12;
        boolean dayValid = day >= 0 && day <= maxDays;

        return yearValid && monthValid && dayValid;

    }

    private void setupDateData() {

        this.setMonthName(this.month);
        this.setDaysInMonth(this.month);

    }

    private int daysInMonth(int month) {

        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return days[month - 1];
    }

    private int daysInYear(int year) {

        if (isLeapYear(year)) {
            return 366;
        } else {
            return 365;
        }
    }

    private boolean isLeapYear(int year) {

        boolean leap;
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
        return leap;
    }

    public static int daysTo(Date date1, Date date2) {
        //Returns the number of days that this Date object must be adjusted to make it equal to the given other Date.
        return 2;
    }

    public int daysTo(Date other) {
        return 1;
    }

    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;
    }

    public String longDate() {
        return  this.monthName + " " + this.day + ", " + this.year;
    }

    private int countDays(int month) {
        int countDays = 0;

        for (int i = 1; i <= month; i++) {
            countDays += daysInMonth(i);
        }

        return countDays - this.day;

    }

}
