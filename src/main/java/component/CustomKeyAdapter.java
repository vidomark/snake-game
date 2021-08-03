package component;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomKeyAdapter extends KeyAdapter {
    private final Snake snake;

    public CustomKeyAdapter(Snake snake) {
        this.snake = snake;
    }

    public void keyPressed(KeyEvent event) {
        snake.keyPressed(event);
    }
}