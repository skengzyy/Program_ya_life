package jerryson;

/**
 * Das Interface UserAccount soll selbst geschrieben werden und implementiert werden. Es enthält die Methoden getBalance(),
 * increaseBalance(double uploadCredit) und buyItem(Item item). Die Methode increaseBalance soll den Wert der balance um den durch den Parameter
 * uploadCredit übergebenen Wert erhöhen. Teste die Methoden der Interfaces in deiner main-Methode (falls du dies nicht sowieso schon getan hast).
 * @author isaacjerryson
 * @version 2024-05-02
 */
public interface UserAccount {
  double getBalance();
  void increaseBalance(double uploadCredit) throws NegativeBalanceException;
  boolean buyItem(Item item) throws NegativeBalanceException;
}
