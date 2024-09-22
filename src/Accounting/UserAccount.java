package Accounting;

/**
 * This is the interface that handles all
 */
public interface UserAccount {

    public double getBalance();
    public void increaseBalance(double amount);
    public boolean buyItem(Item item) throws NegativeBalanceException;
}
