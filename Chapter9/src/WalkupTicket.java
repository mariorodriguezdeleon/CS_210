/* Mario Rodriguez, CS 210
 * December 9, 2020
 * Bellevue College
 * Coding Assignment #9 - WalkupTicket Class - Instantiates a walkup ticket obj.
 * Requirements:
 */

public class WalkupTicket extends Ticket {

    public WalkupTicket () {
        this(0);
    }

    public WalkupTicket(int number) {
        super(number);
        this.price = 50;
    }

}
