/* Mario Rodriguez, CS 210
 * November 4, 2020
 * Bellevue College
 * Coding Chapter 3G Quiz - Square faces
 */

import java.awt.*;

public class SquareFaceX {

    public static void main (String [] args) {

        DrawingPanel panel = new DrawingPanel(800, 800);
        Graphics graphics = panel.getGraphics();

        int x = 10;
        int y = 10;

        for(int i = 0; i <= 14; i ++) {
            drawSquare(graphics, x + i*50 , y + i*50 );
            drawSquare(graphics, (x + 700) - i*50 , y + i*50 );
        }

    }

    public static void drawSquare(Graphics graphics, int x, int y) {

        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, 50, 50);
        graphics.setColor(Color.BLUE);
        graphics.fillOval(x+10, y+10, 10, 10);
        graphics.fillOval(x+30, y+10, 10, 10);
        graphics.setColor(Color.RED);
        graphics.drawLine(x+10, y+30, x+40, y+30);

    }

}
