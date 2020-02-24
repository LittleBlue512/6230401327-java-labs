package sirimul.chattipoom.lab9;

import sirimul.chattipoom.lab7.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CanvasDrawerV2 extends CanvasDrawerV1 {
    private static final long serialVersionUID = 1L;

    protected Ball ball;
    protected Keeper keeperLeft, keeperRight;

    public CanvasDrawerV2() {
        super();

        // Create a ball.
        int ballX = CANVAS_WIDTH / 2 - Ball.BALL_DIAMETER / 2;
        int ballY = CANVAS_HEIGHT / 2 - Ball.BALL_DIAMETER / 2;
        this.ball = new Ball(ballX, ballY);

        // Create keepers.
        int keeperY = CANVAS_HEIGHT / 2 - Keeper.KEEPER_HEIGHT / 2;
        this.keeperLeft = new Keeper(0, keeperY);
        this.keeperRight = new Keeper(CANVAS_WIDTH - Keeper.KEEPER_WIDTH, keeperY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Graphics -> Graphics2D
        Graphics2D g2D = (Graphics2D) g;

        // Draw the ball.
        g2D.setColor(Color.YELLOW);
        g2D.draw(this.ball);
        g2D.fill(this.ball);

        // Draw left keeper.
        g2D.setColor(Color.BLUE);
        g2D.draw(this.keeperLeft);
        g2D.fill(this.keeperLeft);

        // Draw right keeper.
        g2D.setColor(Color.RED);
        g2D.draw(this.keeperRight);
        g2D.fill(this.keeperRight);
    }
}