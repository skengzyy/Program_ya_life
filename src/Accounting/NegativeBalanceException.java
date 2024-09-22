package Accounting;

/**
 * This is NegativeBalanceException
 * @author Isaac Jerryson
 * @version 19.03.2024
 */
public class NegativeBalanceException extends Exception {
    public NegativeBalanceException(String message) {
        super(message);
    }

    public NegativeBalanceException(){
           super("Error, You can't input a Negative Balance!!");
    }
}