package entity;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.geom.Ellipse2D;

public class Circle extends Shape {

    public Circle() {
        super();
    }

    public Circle(int x1, int y1, int x2, int y2, Color color , String username) {
        super(username, x1, y1, x2, y2, color);
        //x values
        if (super.getX1() > super.getX2()) {
            super.setUpperLeftX(super.getX2());
        } else {
            super.setUpperLeftX(super.getX1());
        }
        //y values
        if (super.getY1() > super.getY2()) {
            super.setUpperLeftY(super.getY2());
        } else {
            super.setUpperLeftY(super.getY1());
        }

        int width = Math.abs(super.getX1() - super.getX2());
        super.setWidth(width);
        int height = Math.abs(super.getY1() - super.getY2());
        super.setHeight(height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.drawOval(super.getX1(), super.getY1(), super.getX2(), super.getY2());
    }
//    public Ellipse2D.Float drawCircle(int x1, int y1, int x2, int y2) {
//        int x = Math.min(x1, x2);
//        int y = Math.min(y1, y2);
//
//        int width = Math.abs(x1 - x2);
//        int height = Math.abs(y1 - y2);
//
//        return new Ellipse2D.Float(x, y, width, height);
//    }
}
