package Accounting;
/**
 * This is an Item
 * @author Isaac Jerryson
 * @version 14.03.2024
 */
public class Stepper2 {
    public static void main(String[] args) throws NegativeBalanceException {
        // Create a premium account with initial balance and inventory positions
        PremiumAccount premiumAccount = new PremiumAccount(123456, 200.0, 5, 10.0, 20.0, false);

        // Display initial account details
        System.out.println("Initial Premium Account Details:");
        System.out.println(premiumAccount);

        // Charge monthly fee rooster
        System.out.println("\nCharging Monthly Fee...");
        premiumAccount.chargeMonthly();
        System.out.println("Updated Premium Account Details:");
        System.out.println(premiumAccount);

        // Buy items
        Item item1 = new Item("Book", 15.99);
        Item item2 = new Item("Pen", 2.49);

        System.out.println("\nBuying Item 1:");
        boolean boughtItem1 = premiumAccount.buyItem(item1);
        if (boughtItem1) {
            System.out.println("Item 1 bought successfully.");
        } else {
            System.out.println("Failed to buy Item 1.");
        }
        System.out.println("Updated Premium Account Details:");
        System.out.println(premiumAccount);

        System.out.println("\nBuying Item 2:");
        boolean boughtItem2 = premiumAccount.buyItem(item2);
        if (boughtItem2) {
            System.out.println("Item 2 bought successfully.");
        } else {
            System.out.println("Failed to buy Item 2.");
        }
        System.out.println("Updated Premium Account Details:");
        System.out.println(premiumAccount);

        // Attempt to buy another item without sufficient balance
        Item item3 = new Item("Notebook", 5.99);
        System.out.println("\nTrying to buy Item 3:");
        boolean boughtItem3 = premiumAccount.buyItem(item3);
        if (boughtItem3) {
            System.out.println("Item 3 bought successfully.");
        } else {
            System.out.println("Failed to buy Item 3.");
        }
        System.out.println("Updated Premium Account Details:");
        System.out.println(premiumAccount);

        // Display inventory
        System.out.println("\nPremium Account Inventory:");
        for (Item item : premiumAccount.getInventory()) {
            if (item != null) {
                System.out.println(item.itemData());
            }
        }
    }
}
