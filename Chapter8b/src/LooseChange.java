/* Mario Rodriguez, CS 210
 * November 27, 2020
 * Bellevue College
 * Coding Quiz #8b - LoosChange Class - Tracks loose change (pennies, nickels, dimes and quarters)
 * Requirements:

 */

public class LooseChange {

    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;


    public LooseChange() {
        this.setPennies(0);
        this.setNickels(0);
        this.setDimes(0);
        this.setQuarters(0);
    }

    public LooseChange(int pennies, int nickels, int dimes, int quarters) throws IllegalArgumentException {

        boolean validateInput = validateData(pennies, nickels, dimes, quarters);

        if (!validateInput) {
            throw new IllegalArgumentException("Negative coin count not allowed");
        } else {
            this.setPennies(pennies);
            this.setNickels(nickels);
            this.setDimes(dimes);
            this.setQuarters(quarters);
        }

    }

    // Mutators =========================================
    public void setPennies(int pennies) throws IllegalArgumentException {

        if (!validateData(pennies, 0, 0, 0)) {
            throw new IllegalArgumentException("Negative coin count not allowed");
        } else {
            this.pennies = pennies;
        }

    }

    public void setNickels(int nickels) throws IllegalArgumentException {

        if (!validateData(0, nickels, 0, 0)) {
            throw new IllegalArgumentException("Negative coin count not allowed");
        } else {
            this.nickels = nickels;
        }

    }

    public void setDimes(int dimes) throws IllegalArgumentException{

        if (!validateData(0, 0, dimes, 0)) {
            throw new IllegalArgumentException("Negative coin count not allowed");
        } else {
            this.dimes = dimes;
        }

    }

    public void setQuarters(int quarters) throws IllegalArgumentException {

        if (!validateData(0, 0, 0, quarters)) {
            throw new IllegalArgumentException("Negative coin count not allowed");
        } else {
            this.quarters = quarters;
        }

    }

    // Accessors =========================================
    public int getPennies() {
        return pennies;
    }

    public int getNickels() {
        return nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    // Utilities ===========================================
    private boolean validateData(int pennies, int nickels, int dimes, int quarters) {
        return 0 <= pennies && 0 <= nickels && 0 <= dimes && 0 <= quarters;
    }

    public boolean add(LooseChange other) {

        this.pennies += other.getPennies();
        this.nickels += other.getNickels();
        this.dimes += other.getDimes();
        this.quarters += other.getQuarters();

        return true;

    }

    public String toString() {

        int cents = 0;
        int dollars = 0;

        cents = pennies * 1 + nickels * 5 + dimes * 10 + quarters * 25;

        while (cents > 100) {
            cents -= 100;
            dollars += 1;
        }

        if (cents % 100 < 10) {
            return "$"+ dollars + ".0" + cents;
        } else {
            return "$" + dollars + "." + cents;
        }

    }

}
