/* Mario Rodriguez, CS 210
 * December 9, 2020
 * Bellevue College
 * Coding Assignment #9 - AdvancedTicket Class - Instantiates an advance ticket obj.
 */

public class AdvanceTicket extends Ticket {

    protected int days;
    protected boolean isStudent = false;

    public AdvanceTicket(int number, int day) throws IllegalArgumentException {

        super(number);

        if ( day <= 0) {
            throw new IllegalArgumentException("AdvanceTicket error, cannot be 0 advance");
        } else {
            this.days = day;
            advancedPrice(days);
        }

    }

    public AdvanceTicket() {

        this(0, 0);

    }

    protected void advancedPrice(int days) {

        if (isStudent) {
            if (days >= 10) {
                this.price = 15;
            } else if (days > 0 && days < 10) {
                this.price = 20;
            } else {
                this.price = 50;
            }
        } else {
            if (days >= 10) {
                this.price = 30;
            } else if (days > 0 && days < 10) {
                this.price = 40;
            } else {
                this.price = 50;
            }

        }

    }

    protected int getNumber() {

        String[] str0 = super.toString().split(","); // after -> ["Number: number", "Prices: price"]
        String[] str1 = str0[0].split(" "); // after -> ["Number:", number]

        return Integer.parseInt(str1[1]);

    }

}
