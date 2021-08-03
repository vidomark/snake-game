package component;

import gui.GamePanel;

import java.awt.*;

public class Snake extends Rectangle {

    private final int[] xCoordinates = new int[GamePanel.UNIT_SIZE];
    private final int[] yCoordinates = new int[GamePanel.UNIT_SIZE];
    int bodyParts = 0;
    int foodEaten;
    Direction direction;

    public Snake(int x, int y, int WIDTH, int HEIGHT) {
        super(x, y, WIDTH, HEIGHT);
    }

    public void draw(Graphics graphics) {
        // shiftCoordinates();
        graphics.setColor(new Color(52, 124, 44));

        for (int i = 0; i <= bodyParts; i++) {
            if (i == 0) { // Head of snake
                graphics.setColor(Color.GREEN);
                graphics.fillRect(xCoordinates[i], yCoordinates[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
            } else { // Body of snake
                graphics.setColor(new Color(45, 180, 0));
                graphics.fillRect(xCoordinates[i], yCoordinates[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
            }
        }
    }
}
