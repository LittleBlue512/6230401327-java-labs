package sirimul.chattipoom.lab9;

import java.awt.geom.Ellipse2D;

public class Ball extends Ellipse2D.Double {
    private static final long serialVersionUID = 1L;

    public final static int BALL_DIAMETER = 30;
    private int xVelocity;
    private int yVelocity;

    public Ball(int x, int y) {
        super(x, y, BALL_DIAMETER, BALL_DIAMETER);
        this.xVelocity = 0;
        this.yVelocity = 0;
    }

    public Ball(int x, int y, int _xVelocity, int _yVelocity) {
        super(x, y, BALL_DIAMETER, BALL_DIAMETER);
        this.xVelocity = _xVelocity;
        this.yVelocity = _yVelocity;
    }

    public void move() {
        this.x += xVelocity;
        this.y += yVelocity;
    }

    public int getXVelocity() {
        return this.xVelocity;
    }

    public void setXVelocoty(int val) {
        this.xVelocity = val;
    }

    public int getYVelocity() {
        return this.yVelocity;
    }

    public void setYVelocity(int val) {
        this.yVelocity = val;
    }
}