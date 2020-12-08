/* Mario Rodriguez, CS 210
 * December 9, 2020
 * Bellevue College
 * Coding Assignment #9 - StudentAdvanceTicket Class - Instantiates a student advance ticket obj.
 * Requirements:
 */

public class StudentAdvanceTicket extends AdvanceTicket {

    public StudentAdvanceTicket(int number, int days) {

        super(number, days);
        this.isStudent = true;
        advancedPrice(this.days);

    }

    public StudentAdvanceTicket() {
        this(0, 0);
    }

    public String toString() {

        String str = super.toString();
        return str + " (ID required)";

    }

}
