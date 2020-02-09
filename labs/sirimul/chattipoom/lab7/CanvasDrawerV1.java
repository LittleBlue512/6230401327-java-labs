package sirimul.chattipoom.lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.*;

import javax.swing.JPanel;

public class CanvasDrawerV1 extends JPanel {
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final int CANVAS_WIDTH = 800, CANVAS_HEIGHT = 500;
    private static final float LINE_WIDTH = 4f;
    private static final double DOT_CIRCLE_RADIUS = 5f, CIRCLE_RADIUS = 50f;
    private static final Color CANVAS_BACKGROUND = Color.GREEN;

    public CanvasDrawerV1() {
        super();
        this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setBackground(CANVAS_BACKGROUND);
    }

    @Override
    public void paintComponent(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();

        super.paintComponent(g);

        // Graphics -> Graphics2D
        Graphics2D g2D = (Graphics2D) g;

        // Set things ~
        g2D.setStroke(new BasicStroke(LINE_WIDTH));
        g2D.setColor(Color.BLACK);

        // Center line.
        g2D.draw(new Line2D.Double(width / 2, 0, width / 2, height));

        // Inner rectangle. (Left)
        g2D.draw(new Rectangle2D.Double(0, 150, 60, 200));
        // Inner rectangle. (Right)
        g2D.draw(new Rectangle2D.Double(width - 60, 150, 60, 200));

        // Outter rectagle. (Left)
        g2D.draw(new Rectangle2D.Double(0, 80, 150, 340));
        // Outter rectagle. (Right)
        g2D.draw(new Rectangle2D.Double(width - 150, 80, 150, 340));

        Ellipse2D.Double ellipse2D;

        // Filled circle. (Left)
        ellipse2D = new Ellipse2D.Double(105 - DOT_CIRCLE_RADIUS, 250 - DOT_CIRCLE_RADIUS, DOT_CIRCLE_RADIUS * 2,
                DOT_CIRCLE_RADIUS * 2);
        g2D.draw(ellipse2D);
        g2D.fill(ellipse2D);
        // Filled circle. (Right)
        ellipse2D = new Ellipse2D.Double(width - 105 - DOT_CIRCLE_RADIUS, 250 - DOT_CIRCLE_RADIUS,
                DOT_CIRCLE_RADIUS * 2, DOT_CIRCLE_RADIUS * 2);
        g2D.draw(ellipse2D);
        g2D.fill(ellipse2D);

        g2D.setColor(Color.WHITE);

        // Center circle.
        ellipse2D = new Ellipse2D.Double(width / 2 - CIRCLE_RADIUS, height / 2 - CIRCLE_RADIUS, CIRCLE_RADIUS * 2,
                CIRCLE_RADIUS * 2);
        g2D.draw(ellipse2D);
    }
}