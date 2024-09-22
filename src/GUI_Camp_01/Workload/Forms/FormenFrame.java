package GUI_Camp_01.Workload.Forms;
import javax.swing.*;

public class FormenFrame extends JFrame{
    public FormenFrame(String title, JPanel layout){
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(layout);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
