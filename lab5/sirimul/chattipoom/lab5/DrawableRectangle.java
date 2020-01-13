/**
 * This program is to create a class "DrawableRectangle"
 * which extends from class "Rectangle" and implements interfaces "Movable" and "Drawable"
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 13, 2020
 */

package sirimul.chattipoom.lab5;

public class DrawableRectangle extends Rectangle implements Movable, Drawable {
    private double x;
    private double y;

    public DrawableRectangle() {
        super();
        this.x = 0.0;
        this.y = 0.0;
    }

    public DrawableRectangle(double _x, double _y) {
        super();
        this.x = _x;
        this.y = _y;
    }

    public DrawableRectangle(double _x, double _y, double _width, double _length, String _color, boolean _filled) {
        super(_width, _length, _color, _filled);
        this.x = _x;
        this.y = _y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double _x) {
        this.x = _x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double _y) {
        this.y = _y;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Implement interface

    @Override
    public void moveUp(int val) {
        this.y += val;
    }

    @Override
    public void moveDown(int val) {
        this.y -= val;
    }

    @Override
    public void moveLeft(int val) {
        this.x -= val;
    }

    @Override
    public void moveRight(int val) {
        this.x += val;
    }

    @Override
    public String draw() {
        return String.format("draw a rectangle with top left corner at (%.1f,%.1f) with width=%.1f length=%.1f", this.x, this.y, this.width, this.length);
    }
}