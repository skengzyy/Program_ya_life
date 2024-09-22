package Exception;
import javax.swing.*;
/**
 * This is ExceptionPumping 
 * Using this File to teach MysELF 
 * tHE bEaUTY of "ExceptionHandling & Custüm-Exceptíoné";
 * @author Isaac Jerryson
 * @version 20.04.2024
 */
public class UsingExceptions {


    /**
     * This Method attempts to attemts the user's Body-Surface
     * This Method also relies on the user's honesty
     * 
     * @return the body surface as a double
     * @throws NumberFormatException
     */
    public static void bodySurfaceMeasurments() throws NumberFormatException {
            

        String user_height = JOptionPane.showInputDialog(null, "Please input your height in cm, respectively", JOptionPane.INFORMATION_MESSAGE);
        String user_weight = JOptionPane.showInputDialog(null, "Please input your weight in kg, respectively", JOptionPane.INFORMATION_MESSAGE);

        int height = Integer.parseInt(user_height);
        int weight = Integer.parseInt(user_weight);

        double bodySurface = Math.sqrt((height * weight) / 3600);

        String result = String.format("%.10f", bodySurface);
        bodySurface = Double.parseDouble(result);

        JOptionPane.showMessageDialog(null, "Your Body-Surface's Value is: "+ bodySurface, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static double heartRate() throws NumberFormatException {
        String user_age = JOptionPane.showInputDialog(null, "Please input your height as an Integer, respectively");

        int age = Integer.parseInt(user_age);
        return 220 - age;
    }

    public static void main(String[] args) {
        
    }

    }
