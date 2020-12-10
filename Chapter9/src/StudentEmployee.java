/* Mario Rodriguez, CS 210
 * December 9, 2020
 * Bellevue College
 * Coding Quiz #9 - StudentEmployee Class - Instantiates a student employee obj.
 * Requirements:
 * StudentEmployee Class must inherit ALL methods from the BCEmployee parent Class.
 * - All BC employees secretly have their pay constrained such that the dime and penny digits add to three,
 *   OR total pay is zero.  For example, $12.30 is allowed (3+0=3) but $12.35 is not (3+5=8).  Y
 *   ou must inherit this routine (use super. and DO NOT copy/paste that algorithm).
 * - Student Employee has an additional constructor, accepting String and double parameters, for student
 *   name and pay rate (see example below).
 * - Student Employees have an additional void method named volunteer that accepts no parameters,
 *   and sets that student pay rate to zero.
 * - Student Employees MUST use the parent toString() for printing, but add on the word "Student" as shown below.
 * - Your submission must also meet my Class (data structure) Submission Requirements
 */

public class StudentEmployee extends BCEmployee{

    public StudentEmployee(String name, double rate) {

        this();
        this.setName(name);
        this.setHourlyPay(rate);
    }

    public StudentEmployee() {
        super();
    }

    public void volunteer() {
        this.setHourlyPay(0);
    }

    public String toString() {
        return "Student " + super.toString();
    }

}
