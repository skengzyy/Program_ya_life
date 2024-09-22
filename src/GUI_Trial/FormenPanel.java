package GUI_Trial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *
 * @author Isaac Jerryson
 * @version 28.05.2024
 */
public class FormenPanel extends JPanel {
    FormenGrafik formenGrafik;
    JTextField breiteFeld, hoeheFeld;
    JButton rotButton, gruenButton, blauButton, dreieckButton, rauteButton, rechteckButton, fuellungButton;
    JLabel status;

    public FormenPanel() {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        formenGrafik = new FormenGrafik(1, Color.BLACK, 100, 100, false);
        breiteFeld = new JTextField("100",5);
        hoeheFeld = new JTextField("100",5);
        rotButton = new JButton("Rot");
        gruenButton = new JButton("Grün");
        blauButton = new JButton("Blau");
        dreieckButton = new JButton("Dreieck");
        rauteButton = new JButton("Raute");
        rechteckButton = new JButton("Rechteck");
        fuellungButton = new JButton("Hohl");

        status = new JLabel();
        status.setOpaque(true);
        status.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        status.setText("Status: Bereit");
        this.add(status, BorderLayout.SOUTH);

        JPanel left = new JPanel();
        formenGrafik.setBackground(Color.GRAY);
        left.add(formenGrafik);

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(5, 1));

        JPanel panelReiheForm = new JPanel();
        panelReiheForm.add(new JLabel("Form:"));
        panelReiheForm.add(dreieckButton);
        panelReiheForm.add(rauteButton);
        panelReiheForm.add(rechteckButton);
        main.add(panelReiheForm);

        JPanel panelReiheHoehe = new JPanel();
        panelReiheHoehe.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelReiheHoehe.add(new JLabel("Höhe:"));
        panelReiheHoehe.add(hoeheFeld);
        main.add(panelReiheHoehe);

        JPanel panelReiheBreite = new JPanel();
        panelReiheBreite.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelReiheBreite.add(new JLabel("breiteFeld:"));
        panelReiheBreite.add(breiteFeld);
        main.add(panelReiheBreite);

        JPanel panelReiheFarbe = new JPanel();
        panelReiheFarbe.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelReiheFarbe.add(new JLabel("Farbe:"));
        panelReiheFarbe.add(rotButton);
        panelReiheFarbe.add(blauButton);
        panelReiheFarbe.add(gruenButton);
        main.add(panelReiheFarbe);

        JPanel panelReiheFuellung = new JPanel();
        panelReiheFuellung.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelReiheFuellung.add(new JLabel("Füllung:"));
        panelReiheFuellung.add(fuellungButton);
        main.add(panelReiheFuellung);

        this.add(left, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);

        this.setVisible(true);

        ActionHandler handler = new ActionHandler();

        this.breiteFeld.addActionListener(handler);
        this.hoeheFeld.addActionListener(handler);

        this.dreieckButton.addActionListener(handler);
        this.rauteButton.addActionListener(handler);
        this.rechteckButton.addActionListener(handler);
        this.rotButton.addActionListener(handler);
        this.gruenButton.addActionListener(handler);
        this.blauButton.addActionListener(handler);
        this.fuellungButton.addActionListener(handler);
    }

    public class ActionHandler implements ActionListener {
        private boolean hohl;

        public ActionHandler() {
            hohl = false;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            if (o == dreieckButton) {
                formenGrafik.setForm(1);
                status.setText("Status: Form geändert");
            } else if (o == rauteButton) {
                formenGrafik.setForm(2);
                status.setText("Status: Form geändert");
            } else if (o == rechteckButton) {
                formenGrafik.setForm(0);
                status.setText("Status: Form geändert");
            } else if (o == breiteFeld) {
                try {
                    formenGrafik.setWidth(Integer.parseInt(breiteFeld.getText()));
                    status.setText("Status: breiteFeld geändert");
                } catch (NumberFormatException ex) {
                    formenGrafik.setWidth(0);
                    status.setText("Status: Fehler bei der Eingabe");
                }
            } else if (o == hoeheFeld) {
                try {
                    formenGrafik.setHeight(Integer.parseInt(hoeheFeld.getText()));
                    status.setText("Status: Höhe geändert");
                } catch (NumberFormatException ex) {
                    formenGrafik.setHeight(0);
                    status.setText("Status: Fehler bei der Eingabe");
                }
            } else if (o == rotButton) {
                formenGrafik.setFarbe(Color.RED);
                status.setText("Status: Farbe geändert");
            } else if (o == gruenButton) {
                formenGrafik.setFarbe(Color.GREEN);
                status.setText("Status: Farbe geändert");
            } else if (o == blauButton) {
                formenGrafik.setFarbe(Color.BLUE);
                status.setText("Status: Farbe geändert");
            } else if (o == fuellungButton) {
                if (hohl) {
                    fuellungButton.setText("Hohl");
                } else {
                    fuellungButton.setText("Gefüllt");
                }
                formenGrafik.setHohl(!hohl);
                hohl = !hohl;
                status.setText("Status: Füllung geändert");
            }
        }
    }
}
