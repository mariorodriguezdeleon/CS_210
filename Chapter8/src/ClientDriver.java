import java.awt.*;

public class ClientDriver {
    public static void main (String[] args) {

        // "[(22, 3), (4, 7)]" from Practice-IT
        Line zero = new Line();
        Line little = new Line(new Point(22, 3), new Point(4,7));
        Line other = new Line(new Point(100, 100), new Point(200, 200));
        Line testLine = new Line(new Point(150, 100), new Point(50, 150));

        System.out.println(little.print());
        System.out.println(zero.print());

        DrawingPanel panel = new DrawingPanel(200, 200);
        Graphics canvas = panel.getGraphics();
        little.plot(canvas);
        other.plot(canvas);
        testLine.plot(canvas);

        System.out.println("Values for little");
        System.out.println("Point 1: " +little.getP1());
        System.out.println(("Point2: " +little.getP2()));
        System.out.println("Slope: " + little.getSlope());
        System.out.println("Length: " + little.getLength());
        System.out.println("Intersects: " + little.intersect(other)); //false

        System.out.println();

        System.out.println("Values for little ");
        System.out.println("Point 1: " + other.getP1());
        System.out.println(("Point2: " + other.getP2()));
        System.out.println("Slope: " + other.getSlope());
        System.out.println("Length: " + other.getLength());
        System.out.println("Intersects: " + other.intersect(little));//false
        System.out.println("Intersects: " + other.intersect(testLine)); //true
    }
}
