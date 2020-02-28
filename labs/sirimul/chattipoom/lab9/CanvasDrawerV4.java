package sirimul.chattipoom.lab9;

public class CanvasDrawerV4 extends CanvasDrawerV3 {
    private static final long serialVersionUID = 1L;

    public CanvasDrawerV4() {
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

    protected boolean isBounceKeeperRight() {
        return this.ball.x + Ball.BALL_DIAMETER >= this.keeperRight.x
                && this.ball.y + Ball.BALL_DIAMETER / 2 >= this.keeperRight.y
                && this.ball.y + Ball.BALL_DIAMETER / 2 <= this.keeperRight.y + Keeper.KEEPER_HEIGHT;
    }

    protected boolean isBounceKeeperLeft() {
        return this.ball.x <= this.keeperLeft.x + Keeper.KEEPER_WIDTH
                && this.ball.y + Ball.BALL_DIAMETER / 2 >= this.keeperLeft.y
                && this.ball.y + Ball.BALL_DIAMETER / 2 <= this.keeperLeft.y + Keeper.KEEPER_HEIGHT;
    }
}
