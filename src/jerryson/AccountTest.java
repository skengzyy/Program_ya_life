package jerryson;

/**
 * Testklassse für Account
 * @author Isaac Jerryson
 * @version 2024-05-02
 */
public class AccountTest {
    public static void main(String[] args) throws NegativeBalanceException {

        //ACCOUNT
        
        System.out.println(" ");
        System.out.println("ACCOUNT: ");
        Account konto = new Account(1, 100, 10);
        Item doener = new Item("Döner", 7.50);
        konto.buyItem(doener);
        System.out.println(konto.toString());
        System.out.println("Hashcode:" + konto.hashCode());
        System.out.println(" ");

        //PREMIUM ACCOUNT
        
        System.out.println("PREMIUM ACCOUNT: ");
        PremiumAccount premiumAccount = new PremiumAccount(2, 500,10, 5,25);
        System.out.println(premiumAccount.toString());
        Item trumpSchuhe = new Item("Trump Sneakers", 400);
        premiumAccount.chargeMonthlyFee();
        premiumAccount.buyItem(trumpSchuhe);
        System.out.println(premiumAccount.toString());
        System.out.println("Hashcode:" + premiumAccount.hashCode());

        System.out.println("_____________");
        System.out.println(" ");
        Account player1 = new Account(1, 100.0, 10);
        System.out.println("Account: " + player1);
        System.out.println("Hashcode player1:" + player1.hashCode());
        Account player2 = new Account(1, 100.0, 10);
        System.out.println("Hashcode player2:" + player2.hashCode());
        System.out.println("Vergleich: " + player1.equals(player2));


    }

}
