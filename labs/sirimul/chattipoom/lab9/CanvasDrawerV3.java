package sirimul.chattipoom.lab9;

import java.util.concurrent.ThreadLocalRandom;

public class CanvasDrawerV3 extends CanvasDrawerV2 implements Runnable {
    private static final long serialVersionUID = 1L;

    protected static final int minRand = 1, maxRand = 4;

    protected Thread running;

    public CanvasDrawerV3() {
        super();
        running = new Thread(this);

        // Create a random int whose value is between 1 and 4 for xv and yv.
        // From Googling ~
        int randX = ThreadLocalRandom.current().nextInt(minRand, maxRand + 1);
        int randY = ThreadLocalRandom.current().nextInt(minRand, maxRand + 1);

        int xv = randX;
        int yv = randY;

        this.ball.setXVelocoty(xv);
        this.ball.setYVelocity(yv);

        running.start();
    }

    @Override
    public void run() {
        while (true) {
            if (isHitHorizontal()) {
                // Check if the ball is hit the part that it can bounce.
                if (isHitBounce()) {
                    // Get ball's current x velocity.
                    int xVelocity = this.ball.getXVelocity();
                    // Set ball's new x velocity.
                    this.ball.setXVelocoty(xVelocity * -1);
                } else {
                    
                }

            } else if (isHitVertical()) {
                // Get ball's current y velocity.
                int yVelocity = this.ball.getYVelocity();
                // Set ball's new y velocity.
                this.ball.setYVelocity(yVelocity * -1);
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
}