package Accounting;
/**
 * This is Account
 * @author Isaac Jerryson
 * @version 14.03.2023
 */
public class PremiumTest {
    public static void main(String[] args) {
        try{
            // Creating an account with accountId 123456, initial balance of 1000.0, and 5 inventory positions
            Account account = new Account(123456, 1000.0, 5);

            // Displaying initial account details
            System.out.println("Initial Account Details:");
            System.out.println(account);

            // Creating items
            Item item1 = new Item("Laptop", 300.0);
            Item item2 = new Item("Headphones", 50.0);

            // Buying items
            System.out.println("Buying items...");

            if (account.buyItem(item1)) {
                System.out.println("Bought: " + item1.getName());
            } else {
                System.out.println("Failed to buy: " + item1.getName());
            }

            if (account.buyItem(item2)) {
                System.out.println("Bought: " + item2.getName());
            } else {
                System.out.println("Failed to buy: " + item2.getName());
            }

            // Displaying account details after purchases
            System.out.println("Account Details after purchases:");
            System.out.println(account);

            // Increasing balance
            System.out.println("Increasing balance by 500.0...");
            account.increaseBalance(500.0);

            // Displaying account details after increasing balance
            System.out.println("Account Details after increasing balance:");
            System.out.println(account);

        } catch (NegativeBalanceException e) {
            System.err.println("Error: Negative balance not allowed.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
