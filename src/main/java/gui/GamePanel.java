package gui;

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

    GamePanel() {
        random = new Random();

        this.setBackground(Color.BLACK);
        this.setPreferredSize(dimension);
        this.setFocusable(true);

        gameThread = new Thread(this);
        gameThread.start();
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
                repaint();
                delta--;
            }
        }
    }
}