package Accounting;
import java.util.Random;

/**
 * This is Account
 * @author Isaac Jerryson
 * @version 14.03.2023
 */
public class Account implements Indentifizierbar, UserAccount{
    private int accountId;
    private double balance;
    private Item[] inventory;

    public Account(int accountId, double balance, int positions) throws NegativeBalanceException {
        setAccountId(accountId);
        setBalance(balance);
        setInventory(positions);
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
        if (accountId >= 100000 && accountId <= 999999) this.accountId = accountId;
        else throw new IllegalArgumentException("Invalid account ID");
    }

    public int generateId() {
        Random random = new Random();
        return random.nextInt(1000000); // Generate random number between 100000 and 999999
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void increaseBalance(double amount) {
        if(amount > 0) this.balance += amount;
    }

    public void setBalance(double balance) throws NegativeBalanceException{
        if(!(balance < 0)) this.balance = balance;
        else throw new NegativeBalanceException();
    }

    public Item[] getInventory() {
        return this.inventory;
    }

    public void setInventory(int positions) {
        if (positions >= 1 && positions <= 10) this.inventory = new Item[positions];
        else throw new IllegalArgumentException("Invalid positions");
    }

    @Override
    public String toString() {
        return "Account-Id: " + getAccountId() + "\nAccount-Balance: " + getBalance() + "\nAccount-Inventory: " + formatInformation();
    }

    @Override
    public boolean buyItem(Item item) throws NegativeBalanceException {
        if (item != null) {
            if (getBalance() - item.getCost() >= 0) {
                if (getInventory() != null) {
                    for (int i = 0; i < getInventory().length; i++) {
                        if (getInventory()[i] == null) {
                            getInventory()[i] = item;
                            setBalance(getBalance() - item.getCost());
                            return true;
                        }
                    }
                }
            } else {
                System.err.println("Sie haben nicht genügend Guthaben für dieses Item.");
            }
        }
        return false;
    }

    public String formatInformation() {
        StringBuilder format = new StringBuilder();
        format.append("\nInventory-Data:\n\n");
        for (Item item : this.inventory) {
            if (item != null) {
                format.append(item.itemData()).append("\n");
            }
        }
        return format.toString();
    }

    @Override
    public int hashCode() {
        return (int) (getAccountId() + getBalance() + getInventory().length);
    }

    @Override
    public void identifier() {
        String accountT = String.valueOf(accountId);
        if (accountT.length() < 10) {
            StringBuilder sb = new StringBuilder(accountT);
            while (sb.length() < 10) {
                sb.insert(0, "0");
            }
            accountT = sb.toString();
        }
        setAccountId(Integer.parseInt(accountT));
    }

}
