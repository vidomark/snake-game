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
    }
}