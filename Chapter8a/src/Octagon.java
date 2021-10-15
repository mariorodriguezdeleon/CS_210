/* Mario Rodriguez, CS 210
 * November 23, 2020
 * Bellevue College
 * Coding Quiz 8a - Octagon Class
 */


import java.awt.*;
import java.math.BigDecimal;

public class Octagon {
    private Point center; // required to center of the octagon
    private double side; //the length of one side

    public Octagon() {
        center = new Point();
        side = 0;
    }

    public Octagon(Point c, double s) {
        this.center = c;
        this.side = s;
    }

    public Point getCenter() {
        return center;
    }

    public double getSide() {
        return side;
    }

    public void setCenter(Point c) {
        this.center = c;
    }

    public void setSide(double s) {
        this.side = s;
    }

    public double area() {


        return 2 * Math.pow(this.side, 2) * (1 + Math.sqrt(2));
    }

    public double perimeter() {
        return side * 8;
    }
}
