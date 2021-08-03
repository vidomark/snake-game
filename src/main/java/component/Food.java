package component;

import gui.GamePanel;

import java.awt.*;

public class Food extends Rectangle {

    public Food(int x, int y, int WIDTH, int HEIGHT) {
        super(x, y, WIDTH, HEIGHT);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(x, y, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
    }
}
