package entity;

import java.awt.Color;
import java.awt.Graphics;

//public class Shape 
public abstract class Shape implements Drawable 
{

    //private values
    public String username;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Color color;

    //public values
    public int width;
    public int height;
    public int upperLeftX;
    public int upperLeftY;

    //constructors
    public Shape(String username, int x1, int y1, int x2, int y2, Color color) {
        this.username = username;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }

    public Shape() {
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
        color = Color.BLACK;
    }

    //Getters and Setters
    //String user
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //int x1
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    //int x2
    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    //int y1
    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    //int y2
    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    //Color color
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //int width
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    //int height
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //int upperLeftX
    public int getUpperLeftX() {
        return upperLeftX;
    }

    public void setUpperLeftX(int upperLeftX) {
        this.upperLeftX = upperLeftX;
    }

    //int upperLeftY
    public int getUpperLeftY() {
        return upperLeftY;
    }

    public void setUpperLeftY(int upperLeftY) {
        this.upperLeftY = upperLeftY;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
    }
}
