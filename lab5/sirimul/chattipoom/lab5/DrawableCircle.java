package sirimul.chattipoom.lab5;

public class DrawableCircle extends Circle implements Movable, Drawable {
    private double x;
    private double y;

    public DrawableCircle() {
        super();
        this.x = 0.0;
        this.y = 0.0;
    }

    public DrawableCircle(double _x, double _y) {
        super();
        this.x = _x;
        this.y = _y;
    }

    public DrawableCircle(double _x, double _y, double _radius, String _color, boolean _filled) {
        super(_radius, _color, _filled);
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
        return String.format("draw a circle with the center at (%.1f,%.1f) with radius=%.1f", this.x, this.y, this.radius);
    }
}