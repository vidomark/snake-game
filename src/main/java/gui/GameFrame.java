package gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    GamePanel panel;

    public GameFrame() {
        panel = new GamePanel();
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}