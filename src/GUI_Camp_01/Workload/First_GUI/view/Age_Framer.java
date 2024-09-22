package GUI_Camp_01.Workload.First_GUI.view;

import javax.swing.*;

public class Age_Framer extends JFrame {
    public Age_Framer(String titel, JPanel panel){
        super("titel");
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
