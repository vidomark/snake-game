package component;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {
    private final Snake snake;

    public MyKeyAdapter(Snake snake) {
        this.snake = snake;
    }

    public void keyPressed(KeyEvent event) {
        snake.keyPressed(event);
    }
}