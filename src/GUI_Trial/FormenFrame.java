package GUI_Trial;

import javax.swing.*;

/**
 *
 *
 * @author Isaac Jerryson
 * @version 28.05.2024
 */
public class FormenFrame extends JFrame{
    FormenFrame() {
        this.setTitle("Verschiedene Formen Jerryson");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        FormenPanel panel = new FormenPanel();
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FormenFrame();
    }
}
