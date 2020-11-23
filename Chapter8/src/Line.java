/* Mario Rodriguez, CS 210
* November 23, 2020
* Bellevue College
* Coding Assignment #8A- Line Obj Implementation
*   - This class implements a Line object using the Point Class from java.awt.*
*   - requested requirements to implement:
*       - A zero parameter default constructor that calls 'this'
*       - Avoid System.out in the Class design
*       - Boolean intersect() method ( considering overlap as intersection)
*       - Implement getSlope() that returns the slope as double
*       - Implement getLength() that returns the length as double
*       - Keep plot() to validate working code
*/

import java.awt.*;

public class Line {

    private Point p1;
    private Point p2;

    //CONSTRUCTORS ==================================

    //Zero constructor
    public Line() {
        p1 = new Point();
        p2 = new Point();
    }

    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    //MUTATORS ======================================

    //Additional setters to change/update the points of the line
    public void setP1(Point p) {
        p1 = p;
    }

    public void setP2(Point p) {
        p2 = p;
    }

    //ACCESSORS =====================================

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double getSlope() {
        // m = y2 - y1 / x2 - x1

        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();

        if (x1 == x2) {
            throw new IllegalStateException();
        } else if (y1 == y2) {
            return 0;
        } else {
            return (y2 - y1) / (x2 - x1);
        }
    }

    public double getLength() {
        // d = sqrt((x2 - x1)^2 + (y2 - y1)^2)

        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();

        return Math.sqrt( Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public boolean intersect(Line other) {

        double p1X = this.getP1().getX();
        double p1Y = this.getP1().getY();
        double p2X = this.getP2().getX();
        double p2Y = this.getP2().getY();

        double oX1 = other.getP1().getX();
        double oY1 = other.getP1().getY();
        double oX2 = other.getP2().getX();
        double oY2 = other.getP2().getY();

        double pSlope = this.getSlope();
        double oSlope = other.getSlope();
        double pYIntercept = p1Y - pSlope * p1X;
        double oYIntercept = oY2 - oSlope * oX1;
        double line1 = pSlope * oX1 + pYIntercept;
        double line2 = oSlope * p1X + oYIntercept;

        if (p1X == p2X && oX1 == oX2) { //Lines are parallel and might overlap
            if ( p1X != oX1) { //no overlap
                return false;
            } else if (Math.min(p1Y, p2Y) < Math.min(oY1, oY2)) {//check to verify overlap -> return appropriate bool
                return Math.max(p1Y, p2Y) >= Math.min(oY1, oY2);
            } else {
                return Math.min(p1Y, p2Y) <= Math.max(oY1, oY2);
            }
        }

        if (p1X == p2X) {
            return line2 >= Math.min(p1Y, p2Y) && line2 <= Math.max(p1Y, p2Y) && p1X >= Math.min(oX1, oX2) && p1X <= Math.max(oX1, oX2);
        }

        if (oX1 == oX2) {
            return line1 >= Math.min(oY1, oY2) && line1 <= Math.max(oY1, oY2) && oX1 >= Math.min(p1X, p2X) && oX1 <= Math.max(p1X, p2X);
        }

        double intersectPoint = -(pYIntercept-oYIntercept) / (pSlope - oSlope);
        return intersectPoint >= Math.min(p1X, p2X) && intersectPoint <= Math.max(p1X, p2X) && intersectPoint >= Math.min(oX1, oX2) && intersectPoint <= Math.max(oX1, oX2);
    }

    //DISPLAY =======================================

    public void plot (Graphics canvas) {

        int x1 = (int) p1.getX();
        int x2 = (int) p2.getX();
        int y1 = (int) p1.getY();
        int y2 = (int) p2.getY();

        canvas.drawLine(x1, y1, x2, y2);
    }

    public String toString() {
        return new String("[(" + p1.getX() + ", " + p1.getY() + "), (" + p2.getX() + ", " + p2.getY() + ")]");
    }

    public String print() {
        return (p1 + " " + p2);
    }

}
