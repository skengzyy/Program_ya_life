package GUI_Trial;

import javax.swing.*;
import java.awt.*;

/**
 *
 *
 * @author Isaac Jerryson
 * @version 28.05.2024
 */
public class FormenGrafik extends JPanel {
    private int form;
    private Color farbe;
    private int width;
    private int height;
    private boolean hohl;

    public FormenGrafik(int form, Color farbe, int width, int height, boolean hohl) {
        this.setForm(form);;
        this.setFarbe(farbe);
        this.setWidth(width);
        this.setHeight(height);
        this.setHohl(hohl);
    }

    public Dimension getPreferredSize() {
        return new Dimension(150, 200);
    }

    public void setForm(int form) throws IllegalArgumentException {
        if (form > 2 || form < 0) {
            throw new IllegalArgumentException("Keine existierende Form!");
        }
        this.form = form;
        this.repaint();
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
        this.repaint();
    }

    public void setWidth(int width) {
        if (width < 0) {
            throw new IllegalArgumentException("Muss positiv sein.");
        }
        this.width = width;
        this.repaint();
    }

    public void setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Muss positiv sein.");
        }
        this.height = height;
        this.repaint();
    }

    public void setHohl(boolean hohl) {
        this.hohl = hohl;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics formenGrafik) {
        super.paintComponent(formenGrafik);

        int y = this.getHeight() / 2;
        int x = this.getWidth() / 2;

        formenGrafik.setColor(farbe);

        switch(this.form) {
            case 0:
                if (hohl) {
                    formenGrafik.drawRect(x - (width / 2), y - (height / 2), width, height);
                } else {
                    formenGrafik.fillRect(x - width / 2, y - height / 2, width, height);
                }
                break;
            case 1:
                int[] xEcke = {x + width / 2, x + width / 2, x - width / 2};
                int[] yEcke = {y + height / 2, y - height / 2, y - height / 2};
                if (hohl) {
                    formenGrafik.drawPolygon(xEcke, yEcke, 3);
                } else {
                    formenGrafik.fillPolygon(xEcke, yEcke, 3);
                }
                break;
            case 2:
                int[] xEcken = {x - width / 4, x, x + width / 4, x};
                int[] yEcken = {y, y + height / 2, y, y - height / 2};
                if (hohl) {
                    formenGrafik.drawPolygon(xEcken, yEcken, 4);
                } else {
                    formenGrafik.fillPolygon(xEcken, yEcken, 4);
                }
                break;
            default:
                break;
        }
    }
}
