package sirimul.chattipoom.lab9;

import java.awt.geom.Rectangle2D;

public class Keeper extends Rectangle2D.Double {
    private static final long serialVersionUID = 1L;

    public final static int KEEPER_WIDTH = 20;
    public final static int KEEPER_HEIGHT = 50;
    public final static int KEEPER_SPEED = 10;

    public Keeper(int x, int y) {
        super(x, y, KEEPER_WIDTH, KEEPER_HEIGHT);
    }

    public void moveUp() {
        if (this.y - KEEPER_SPEED >= 150) {
            this.y = this.y - KEEPER_SPEED;
        }
    }

    public void moveDown() {
        if (this.y + KEEPER_HEIGHT + KEEPER_SPEED <= 350) {
            this.y = this.y + KEEPER_SPEED;
        }
    }
}