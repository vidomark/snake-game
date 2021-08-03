package gui;

import component.Food;
import component.CustomKeyAdapter;
import component.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    public final static int GAME_WIDTH = 1200;
    public final static int GAME_HEIGHT = 1200;
    public final static int UNIT_SIZE = 25;

    Dimension dimension = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    Random random;
    Thread gameThread;
    CustomKeyAdapter keyAdapter;

    Snake snake;
    int snakeX;
    int snakeY;

    Food food;
    int foodX;
    int foodY;

    GamePanel() {
        random = new Random();

        createSnake();
        createFood();

        keyAdapter = new CustomKeyAdapter(snake);

        this.setBackground(Color.BLACK);
        this.setPreferredSize(dimension);
        this.setFocusable(true);
        this.addKeyListener(keyAdapter);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void createSnake() {
        snakeX = random.nextInt(GAME_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        snakeY = random.nextInt(GAME_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        snake = new Snake(snakeX, snakeY, UNIT_SIZE, UNIT_SIZE);
    }

    public void createFood() {
        foodX = random.nextInt((GAME_WIDTH/UNIT_SIZE)) * UNIT_SIZE;
        foodY = random.nextInt((GAME_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
        food = new Food(foodX, foodY, UNIT_SIZE, UNIT_SIZE);
    }

    public void handleCollision() {
        if (snake.eat(food)) {
            createFood();
            snake.grow(food);
        }

        if (snake.selfCollision()) {
            snake.shrink();
        }

        snake.atBorder();
    }

    public void move() {
        try {
            snake.move();
        } catch (Exception ignored) {}
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 15;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                handleCollision();
                move();
                repaint();
                delta--;
            }
        }
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.decode("#949494")); // light grey color
        // draw columns
        for (int i = 0; i < GAME_HEIGHT / UNIT_SIZE; i++) {
            graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, GAME_HEIGHT);
        }

        // draw rows
        for (int i = 0; i < GAME_WIDTH / UNIT_SIZE; i++) {
            graphics.drawLine(0, i * UNIT_SIZE, GAME_WIDTH, i * UNIT_SIZE);
        }

        food.draw(graphics);
        snake.draw(graphics);
    }

    public void paint(Graphics graphics) {
        draw(graphics);
    }
}