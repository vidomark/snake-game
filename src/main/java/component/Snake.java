package component;

import gui.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake extends Rectangle {

    private final int[] xCoordinates = new int[GamePanel.UNIT_SIZE];
    private final int[] yCoordinates = new int[GamePanel.UNIT_SIZE];
    int bodyParts = 0;
    Direction direction;

    public Snake(int x, int y, int WIDTH, int HEIGHT) {
        super(x, y, WIDTH, HEIGHT);
    }

    public boolean eat(Food food) {
        if (food.x == xCoordinates[0] && food.y  == yCoordinates[0]) {
            bodyParts++;
            return true;
        }
        return false;
    }

    public void grow(Food food) {
        int x = food.x;
        int y = food.y;

        xCoordinates[bodyParts] = x; // + 1 to not overwrite the head
        yCoordinates[bodyParts] = y; // + 1 to not overwrite the head
    }

    public void move() {
        for(int i = bodyParts;i>0;i--) {
            xCoordinates[i] = xCoordinates[i-1];
            yCoordinates[i] = yCoordinates[i-1];
        }

        switch (direction) {
            case UP -> yCoordinates[0] -= GamePanel.UNIT_SIZE;
            case DOWN -> yCoordinates[0] += GamePanel.UNIT_SIZE;
            case LEFT -> xCoordinates[0] -= GamePanel.UNIT_SIZE;
            case RIGHT -> xCoordinates[0] += GamePanel.UNIT_SIZE;
        }
    }

    public void atBorder() {
        if (xCoordinates[0] < 0) {
            xCoordinates[0] = GamePanel.GAME_HEIGHT;
        } else if (xCoordinates[0] > GamePanel.GAME_HEIGHT) {
            xCoordinates[0] = 0;
        } else if (yCoordinates[0] < 0) {
            yCoordinates[0] = GamePanel.GAME_HEIGHT;
        } else if (yCoordinates[0] > GamePanel.GAME_WIDTH) {
            yCoordinates[0] = 0;
        }
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_W) {
            direction = Direction.UP;
        } else if (event.getKeyCode() == KeyEvent.VK_S) {
            direction = Direction.DOWN;
        } else if (event.getKeyCode() == KeyEvent.VK_A) {
            direction = Direction.LEFT;
        } else if (event.getKeyCode() == KeyEvent.VK_D) {
            direction = Direction.RIGHT;
        }
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
