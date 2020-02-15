/**
 * This class is to draw several shapes according to lab7 instructions.
 * This class is extended from GraphicsMoverV1.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 11, 2020
 */

package sirimul.chattipoom.lab7;

import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GraphicsMoverV2 extends GraphicsMoverV1 {
    private static final long serialVersionUID = 1L;

    // Constant variables.
    protected static final Font SERIF_BOLD_20 = new Font(Font.SERIF, Font.BOLD, 20);
    private static final String BLUE_TEAM_NAME = "Khonkaen";
    private static final String RED_TEAM_NAME = "Udon Thai";

    // Components
    protected JPanel scorePanel;
    protected JLabel blueLabel, redLabel;
    protected JTextField blueScore, redScore;

    public GraphicsMoverV2(String _frameTitle) {
        super(_frameTitle);
    }

    private void setColors() {
        this.blueLabel.setForeground(Color.BLUE);
        this.redLabel.setForeground(Color.RED);
    }

    private void setFonts() {
        this.blueLabel.setFont(SERIF_BOLD_20);
        this.redLabel.setFont(SERIF_BOLD_20);
        this.blueScore.setFont(SERIF_BOLD_20);
        this.redScore.setFont(SERIF_BOLD_20);
    }

    private void setComponentLayout() {
        this.scorePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, H_PADDING, V_PADDING));
    }

    @Override
    protected void initComponent() {
        super.initComponent();

        this.scorePanel = new JPanel();
        this.blueLabel = new JLabel(BLUE_TEAM_NAME);
        this.redLabel = new JLabel(RED_TEAM_NAME);
        this.blueScore = new JTextField("3");
        this.redScore = new JTextField("1");

        this.setComponentLayout();
        this.setFonts();
        this.setColors();
    }

    @Override
    protected void addComponents() {
        this.scorePanel.add(this.blueLabel);
        this.scorePanel.add(this.blueScore);
        this.scorePanel.add(this.redLabel);
        this.scorePanel.add(this.redScore);

        this.topPanel.add(this.scorePanel);

        super.addComponents();
    }

    public static void createAndShowGUI() {
        final GraphicsMoverV2 graphicsMoverV2 = new GraphicsMoverV2("Graphics Mover Version 2");

        graphicsMoverV2.initComponent();
        graphicsMoverV2.addComponents();
        graphicsMoverV2.setFrameFeatures();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}