/**
 * This class is to move the ball by randomly set its velocity and check its collision.
 * This class extended from CanvasDrawerV2.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 29, 2020
 */

package sirimul.chattipoom.lab9;

import java.util.concurrent.ThreadLocalRandom;

public class CanvasDrawerV3 extends CanvasDrawerV2 implements Runnable {
    private static final long serialVersionUID = 1L;

    protected static final int MIN_RAND = -2, MAX_RAND = 2;

    protected Thread running;

    public CanvasDrawerV3() {
        super();
        running = new Thread(this);

        int xv = randVelocity(MIN_RAND, MAX_RAND);
        int yv = randVelocity(MIN_RAND, MAX_RAND);

        this.ball.setXVelocoty(xv);
        this.ball.setYVelocity(yv);

        running.start();
    }

    @Override
    public void run() {
        while (true) {
            if (isHitHorizontal()) {
                // Check if the ball hit the part that it can bounce.
                if (isHitBounce()) {
                    horizontalBounce();
                } else {
                    // Goal!
                }
            } else if (isHitVertical()) {
                verticalBounce();
            }

            ball.move();

            repaint();

            // Delay
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
        }
    }

    protected int randVelocity(int MIN_RAND, int MAX_RAND) {
        int randNum = 0;

        // Make sure the value is not zero.
        while (randNum == 0)
            // Create a random int whose value is between MIN_RAND and MAX_RAND for xv and
            // yv.
            randNum = ThreadLocalRandom.current().nextInt(MIN_RAND, MAX_RAND + 1);

        return randNum;
    }

    protected boolean isHitBounce() {
        if (this.ball.y + Ball.BALL_DIAMETER / 2 <= 150 || this.ball.y + Ball.BALL_DIAMETER / 2 >= 350)
            return true;
        return false;
    }

    protected boolean isHitHorizontal() {
        if (this.ball.x <= 0 || this.ball.x + Ball.BALL_DIAMETER >= CANVAS_WIDTH)
            return true;
        return false;

    }

    protected boolean isHitVertical() {
        if (this.ball.y <= 0 || this.ball.y + Ball.BALL_DIAMETER >= CANVAS_HEIGHT)
            return true;
        return false;
    }

    protected void verticalBounce() {
        // Get ball's current y velocity.
        int yVelocity = this.ball.getYVelocity();

        // Set ball's new y velocity.
        this.ball.setYVelocity(yVelocity * -1);
    }

    protected void horizontalBounce() {
        // Get ball's current x velocity.
        int xVelocity = this.ball.getXVelocity();

        // Set ball's new x velocity.
        this.ball.setXVelocoty(xVelocity * -1);
    }

    public void resetBall() {
        // Reset position.
        this.ball.x = CANVAS_WIDTH / 2 - Ball.BALL_DIAMETER / 2;
        this.ball.y = CANVAS_HEIGHT / 2 - Ball.BALL_DIAMETER / 2;

        // Get and Set new velocity.
        this.ball.setXVelocoty(randVelocity(MIN_RAND, MAX_RAND));
        this.ball.setYVelocity(randVelocity(MIN_RAND, MAX_RAND));
    }
}
