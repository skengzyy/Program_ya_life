package GUI_Camp_01.Workload.First_GUI.view;
import javax.swing.*;
import java.awt.*;

public class Button_Panel extends JPanel{
    public Button_Panel(){
        BorderLayout basis = new BorderLayout(); // adding the Border-layout Object
        this.setLayout(basis);// setting the Layout

        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(new Color(120,203,230));
        this.setPreferredSize(new Dimension(120,300));

        this.add(label);
    }
}
