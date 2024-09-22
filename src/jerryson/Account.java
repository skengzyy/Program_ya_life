package jerryson;

/**
 * Basisklassen Account & Item zur Verwaltung eines Spieleraccounts: Du programmierst die Klassen zur
 * Accountverwaltung eines Mini-Spiels. In dem Spiel kannst du Items (z.b. Zaubertränke, ...) für deinen Charakter kaufen.
 * @author Isaac Jerryson
 * @version 2023-05-02
 */
public class Account extends NegativeBalanceException implements Identifizierbar, UserAccount {
    // ATTRIBUTE
    private int accountId;
    private double balance;
    private Item[] inventory;



    //KONSTRUKTOR

    /**
     * Konstruktor
     * @param accountId accountid des accounts
     * @param balance des kontos
     * @param length die länge des inventots
     * @throws NegativeBalanceException wenn Balnce unter 0 ist
     */
    public Account(int accountId, double balance, int length) throws NegativeBalanceException {
        setAccountId(accountId);
        setBalance(balance);
        setInventory(length);
    }

    //INTERFACE METHODEN

    /**
     * Methode die dei einterface Methode uberschreibt
     * Es wird die accountId auf 10 Ziffern gesetz
     */
    @Override
    public void identifier() {
        String accountText = String.valueOf(accountId);
        if (accountText.length() < 10) {
            StringBuilder sb = new StringBuilder(accountText);
            while (sb.length() < 10) {
                sb.insert(0, "0");
            }
            accountText = sb.toString();
        }
        setAccountId(Integer.parseInt(accountText));
    }


    /**
     * Die Methode increaseBalance soll den Wert der balance um den durch den Parameter uploadCredit übergebenen Wert erhöhen.
     * @param uploadCredit der Wert der die Balance erhöht
     * @throws NegativeBalanceException wenn Balance unter 0 ist
     */
    @Override
    public void increaseBalance(double uploadCredit) throws NegativeBalanceException {
        if(uploadCredit > 0) {
            setBalance(getBalance() + uploadCredit);
        }
    }


    //SETTER UND GETTER METHODEN

    /**
     * getter Methode fur AccountID
     * @return den AccountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * setter Methode für AccountId
     * @param accountId accountid Nummer
     */
    public void setAccountId(int accountId) {
        if(accountId > 0) {
            this.accountId = accountId;
        } else {
            throw new IllegalArgumentException("Der Account ID muss grösser als 0 sein");
        }
    }

    /**
     * getter Methode fur Balance
     * @return die Balance als Int
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * setter Methode fur balance
     * @param balance die balnce die gesettet werden muss
     * @throws NegativeBalanceException wenn Balance unter 0 ist
     */
    public void setBalance(double balance) throws NegativeBalanceException {
        if(balance > 0) {
            this.balance = balance;
        } else if(balance < 0) {
            throw new NegativeBalanceException();
        }

    }
    /**
     * getter Methode für Inventory
     * @return den inventory
     */
    public Item[] getInventory() {
        return this.inventory;

    }

    /**
     * setter Methode für inventory
     * @param length der inveotry array
     * @throws IllegalArgumentException wenn die iNventar lange nicht 10 ist
     */
    public void setInventory(int length) {
        if(length == 10) {
            this.inventory = new Item[length];
        } else {
            throw new IllegalArgumentException("Das Inventar muss 10 Plätze haben :/");
        }

    }


    //METHODEN

    /**
     * Inventory zu Text
     * @return den Invenoty als Text
     */
    public String inText() {
        String text = "";
        for(int i=0; i < this.inventory.length; i++) {
            if(this.inventory[i] != null) {
                text += this.inventory[i].toString() + " ";
            }
        }
        return text;
    }

    /**
     *  Gibt alle Informationen des Benutzerkontos als String aus.
     * @return die Information des Benutzers als String
     */
    @Override
    public String toString() {
       return "Account ID: " + getAccountId() + "; Balance: " + getBalance() + "; Inventory: " + inText();
    }

    /**
     * Wenn der Account genug Guthaben (= balance) und Platz im Inventar hat, kann das Item gekauft werden
     * und an die erste freie Stelle im Array gespeichert werden. Wenn die Methode erfolgreich war,
     * soll true zurückgegeben werden, ansonsten false.
     * @return true oder false wenn ein Item gekauft wurce
     * @throws NegativeBalanceException wenn Balance unter 0 ist
     * @throws IllegalArgumentException wenn ungueltige Paramter Ubergben wurden
     */
    @Override
    public boolean buyItem(Item item) throws NegativeBalanceException {
        if(item != null && this.balance >= item.getCost()) {
            for(int i = 0; i < this.inventory.length; i++) {
                if(this.inventory[i] == null) {
                    this.inventory[i] = item;
                    setBalance(getBalance() - item.getCost());
                    return true;
                }
            }
        } else {
            throw new IllegalArgumentException("Die ubergebenen Parameter sind ungueltig");
        }
        return false;
    }

    /**
     * Überladen von equals(Object o): Überlade die Methode equals(Object o) in der Klasse Item mit der
     * Methode equals(Item i). Die equals-Methode soll true zurückgeben, wenn alle Attribute des this-Objekts
     * mit den Attributen des Parameterobjekts i übereinstimmen. Überlade die equals Methoden der Klassen
     * Account und PremiumAccount in der gleichen Form. Du kannst für den Vergleich des Array-Inhalts die equals-Methode von Item verwenden.
     * @param account das Item Objekt
     * @throws IllegalArgumentException wenn account null ist
     */
    public boolean equals(Account account) {
        if(account != null) {
            boolean checkInventory = true;
            for(int i = 0; i < account.inventory.length; i++) {
                for(int j = 0; j < inventory.length; j++) {
                    if(account.inventory != null && inventory[j] != null) {
                        if(!account.inventory[i].equals(inventory[j])) {
                            checkInventory = false;
                        }
                    }
                }
            }
            if(this.accountId == account.accountId && this.balance == account.balance && checkInventory) {
                return true;
            }
        } else {
            throw new IllegalArgumentException("Das Account Objekt ist Null :/");
        }
        return false;
    }

    /**
     * Überschreiben hashCode(): Wenn die equals-Methode angepasst wird, muss auch die hashcode-Methoden der entsprechenden Klassen überschrieben werden. Verwende dazu folgende vereinfachte Formel zur Berechnung des Hashcodes:
     * Hashcode = Summe aus allen Zahlenwerten und den Hashcodes aller String-Werte
     * @return hashwert
     */
    @Override
    public int hashCode() {
        return (int) (accountId + balance + inventory.length);
    }

}

