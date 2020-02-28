package sirimul.chattipoom.lab9;

public class CanvasDrawerV5 extends CanvasDrawerV4 {
    private static final long serialVersionUID = 1L;

    public CanvasDrawerV5() {
        super();
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
                    // Check if the ball is disappeared.
                    if (isBallDisappear()) {
                        resetBall();
                    }
                }
            } else if (isHitVertical()) {
                verticalBounce();
            } else if (isBounceKeeperRight()) {
                // Bounce keeper right.
                horizontalBounce();
            } else if (isBounceKeeperLeft()) {
                // Bounce keeper left.
                horizontalBounce();
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

    protected boolean isBallDisappear() {
        return this.ball.x + Ball.BALL_DIAMETER < 0 || this.ball.x > CANVAS_WIDTH;
    }
}
