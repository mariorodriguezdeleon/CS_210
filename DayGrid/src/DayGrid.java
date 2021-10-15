/* Mario Rodriguez, CS 210
 * November 2, 2020
 * Bellevue College
 * Coding Assignment #3G (re-work fo Assignment #4) - DayGrid : Prints out a user readable calendar of the
 *                                  requested month(s) and year from 1900-2100
 *
 * Overloaded method
 *  - showGrid(int month, int year)
 *  - showGrid(Graphics graphics, int month, int year)
 */

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DayGrid {

    public static void main (String [] args) {

        DrawingPanel panel = new DrawingPanel(400, 200);
        panel.setBackground(Color.DARK_GRAY);
        Graphics graphics = panel.getGraphics();

        //test run for all months of 2020 using the command line to print
//        for (int i = 1; i < 13; i++) {
//            showGrid(i, 2020);
//        }

        showGrid(10, 1582);

        //test run for overloaded method to print a panel
        showGrid(graphics,10, 1582);

    }

    //primary method invoked to build and print the calendar
    public static void showGrid(int month, int year) {

        //create a new calendar obj with the supplied parameters
        GregorianCalendar calObj = new GregorianCalendar(year, month - 1, 1);
        String monthName = monthOfYear(calObj.get(Calendar.MONTH));//used for the printCalendar() helper method
        int maxNumOfDays = daysInMonth(month); //get the max number of days in the requested month
        int firstDayOfWeek = calObj.get(Calendar.DAY_OF_WEEK); //get the first day of the week
        boolean isLeapYr = calObj.isLeapYear(calObj.get(Calendar.YEAR));//check to see if it is a leap year
        if (isLeapYr == true && month == 2) {

            maxNumOfDays = 29;

        }//if leap year adjusts the max days for the month of February
        int calModel[][] = buildCalendar(maxNumOfDays, firstDayOfWeek);//holder for calendar model

        printCalendar(calModel, monthName, year);

    }

    //overloaded method of showGrid that takes in a graphics object
    public static void showGrid(Graphics graphics, int month, int year) {

        //create a new calendar obj with the supplied parameters
        GregorianCalendar calObj = new GregorianCalendar(year, month - 1, 1);
        String monthName = monthOfYear(calObj.get(Calendar.MONTH));//used for the printCalendar() helper method
        int maxNumOfDays = daysInMonth(month); //get the max number of days in the requested month
        int firstDayOfWeek = calObj.get(Calendar.DAY_OF_WEEK); //get the first day of the week
        boolean isLeapYr = calObj.isLeapYear(calObj.get(Calendar.YEAR));//check to see if it is a leap year
        if (isLeapYr == true && month == 2) {

            maxNumOfDays = 29;

        }//if leap year adjusts the max days for the month of February
        int calModel[][] = buildCalendar(maxNumOfDays, firstDayOfWeek);//holder for calendar model

        printCalendar(graphics, calModel, monthName, year);

    }

    //returns the day of the week to print
    public static String dayOfWeek( int num) {

        String days[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        return days[num];

    }

    //returns human readable name of the requested month
    public static String monthOfYear (int calMonth) {

        String months [] = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        return months[calMonth];

    }

    //returns the max number of days for the requested month, not adjusted for leap year
    public static int daysInMonth (int month) {

        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return days[month - 1];
    }

    //returns a model of the calendar to be printed
    public static int[][] buildCalendar (int maxNumOfDays, int firstDayOfWeek) {

        int builtCal [][] = new int[6][8]; //array of arrays used to build the calendar model

        int monthDay = 1; //tracker for the day of the month as model is being built

        for(int i = 0; i < 7 ; i++) {

            for(int j = firstDayOfWeek; j <= 7; j++) {

                if(monthDay <= maxNumOfDays) {

                    builtCal [i][j] = monthDay;
                    monthDay++;
                }
            }
            firstDayOfWeek = 1; //keeping with Java standard of setting Sunday as the first day of week
        }
        return builtCal;
    }

    //helper method to print the model created by buildCalendar() method
    public static void printCalendar (int cal[][], String month, int year) {

        System.out.println("--------------------------------------------------");
        System.out.println("                " + month + "   " + year + "      ");
        System.out.println("--------------------------------------------------");
        System.out.println("   Sun    Mon    Tue    Wed    Thr    Fri    Sat");
        System.out.println("+------+------+------+------+------+------+------+");

        for (int i = 0; i < 6; i++) {

            for (int j = 1; j < 8; j++) {

                if (cal[i][j] != 0) {

                    System.out.printf("|%4d  ", cal[i][j]);

                } else {

                    System.out.print("|      ");

                }
            }

            System.out.print("|");
            System.out.println();

        }

        System.out.println("+------+------+------+------+------+------+------+");

    }

    //overloaded method of printCalendar
    public static void printCalendar (Graphics graphics, int cal[][], String monthName, int year) {

        int x = 20;
        int y = 40;

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Monospaced", Font.BOLD, 16));
        graphics.drawString(monthName, 85, 15);
        graphics.drawString(Integer.toString(year), 185, 15);
        graphics.drawRect(x , y , 280,120 );


        //vertical lines
        for (int i = 1; i <= 6; i++){
            graphics.drawLine(x + i * y, y,x + i * y, y * 4);
        }

        //horizontal lines
        for (int i = 1; i <= 5; i++){
            graphics.drawLine(x, y + i * x,x * 15, y + i * x);
        }

        //draw days of the week
        for (int i = 0; i <= 6; i++) {
            graphics.drawString(dayOfWeek(i), (x + x/2) + i * y, y - x/2);
        }

        //print days on calendar
        for (int i = 0; i < 6; i++) {

            for (int j = 1; j < 8; j++) {

                if (cal[i][j] != 0) {

                    graphics.drawString(String.valueOf(cal[i][j]), (x + 15) + (j - 1) * y, (i * x) + y + 15 );

                } else {

                    graphics.drawString("", (x + 15) + (j - 1) * y, (i * x) + y + 15);

                }

            }

        }

    }

}
