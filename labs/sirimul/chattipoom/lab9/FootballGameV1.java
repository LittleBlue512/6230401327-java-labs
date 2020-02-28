package sirimul.chattipoom.lab9;

import javax.swing.SwingUtilities;

public class FootballGameV1 extends GraphicsMoverV4 {
    private static final long serialVersionUID = 1L;

    protected CanvasDrawerV3 canvasDrawerFBG;

    public FootballGameV1(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void initComponent() {
        super.initComponent();

        // Create CanvasDrawerV3.
        this.canvasDrawerFBG = new CanvasDrawerV3();
    }

    @Override
    protected void addComponents() {
        super.addComponents();

        // Remove CanvasDrawerV2.
        this.centerPanel.remove(this.canvasDrawerV2);

        // Add new CanvasDrawer.
        this.centerPanel.add(this.canvasDrawerFBG);
    }

    public static void createAndShowGUI() {
        final FootballGameV1 footballGameV1 = new FootballGameV1("Football Game V1");

        footballGameV1.initComponent();
        footballGameV1.addComponents();
        footballGameV1.setFrameFeatures();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}