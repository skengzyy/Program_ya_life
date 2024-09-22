package jerryson;

/**
 * Klasse PremiumAccount die von Klasse Account erbt
 */
public class PremiumAccount extends Account {
    //ATTRIBUTE
    private double premiumFee; // 5 Euro
    private double discountRate; //in Prozent beim berehcnen wird /100 gemacht
    public boolean feeCharged;

    //KONSTRUKTOR

    /**
     * kONSTRUKTOR fur PremiumAccount
     * @param accountId der accountid als Int
     * @param balance die Blaance des Accounts
     * @throws NegativeBalanceException wenn Balance unter 0 gestetz wird
     */
    public PremiumAccount(int accountId, double balance, int inventory, double premiumFee, double discountRate) throws NegativeBalanceException {
        super(accountId, balance, inventory);
        setPremiumFee(premiumFee);
        setDiscountRate(discountRate);
    }

    //SETTER UND GETTER METHODEN

    /**
     * getter Methode fur Premium Fee
     * @return den premiumFee
     */
    public double getPremiumFee() {
        return premiumFee;
    }

    /**
     * setter Methode für PremiumFee
     * @param premiumFee den PremiumFee
     * @throws NegativeBalanceException wenn Balance uter 0 gesetzt wird
     */
    public void setPremiumFee(double premiumFee) {
        if(premiumFee > 0) {
            this.premiumFee = premiumFee;
        } else {
            throw new IllegalArgumentException("Die premiumFee soll grosseer als 0 sein :/");
        }
    }

    /**
     * getter methode für Discount Rate
     * @return den discount rate
     */
    public double getDiscountRate() {
        return discountRate;
    }

    /**
     * setter Methode für DiscountRate
     * @param discountRate
     * @throws IllegalArgumentException wenn DISCOUNT RSTE NICHT ZWISCHEN 0 UND 100 IST
     */
    public void setDiscountRate(double discountRate) {
        if(discountRate > 0 && discountRate <= 100) {
            this.discountRate = discountRate;
        } else {
            throw new IllegalArgumentException("Die Discount Rate sollte zwischen 0 und 100 sein/");
        }
    }

    /**
     * getter Methode für FeeCharged
     * @return true oder false
     */
    public boolean getFeeCharged() {
        return feeCharged;
    }

    /**
     * setter Methode für FeeCharged
     * @param feeCharged ob eine fee gecharged wurde
     */
    public void setFeeCharged(boolean feeCharged) {
        if(!feeCharged || feeCharged) {
            this.feeCharged = feeCharged;
        }

    }

    //METHODEN

    /**
     * Die Methode zieht die Premium-Gebühr vom Guthaben ab. Die Gebühr wird nur abgezogen,
     * wenn sie noch nicht bezahlt wurde und wenn der Kontostand des Accounts ausreicht. Wenn die
     * Gebühr verrechnet werden konnte, soll das Attribut feeCharged auf true gesetzt werden.
     * @throws IllegalArgumentException wenn die Fee nicht gecharged werden kann
     */
    public void chargeMonthlyFee() throws NegativeBalanceException {
        if(!this.feeCharged && super.getBalance() > 5) {
            super.setBalance(super.getBalance() - 5);
            this.feeCharged = true;
        } else {
            throw new IllegalArgumentException("Monthly cannot be Charged :(");
        }
    }

    /**
     * Eine überschriebene buyItem() Methode, sodass der Premium-Rabatt beim Kauf von
     * Items angewendet wird.
     * @param item das Item Objekt
     * @throws IllegalArgumentException wenn die Parameter ungueltig sind
     */
    @Override
    public boolean buyItem(Item item) throws NegativeBalanceException {
        if(item != null && super.getBalance() >= item.getCost()) {
            for(int i = 0; i < super.getInventory().length; i++) {
                if(super.getInventory()[i] == null) {
                    super.getInventory()[i] = item;

                    if(getFeeCharged()) {
                        super.setBalance(getBalance() - (item.getCost() * (1 - (getDiscountRate()/100))));
                    } else if(!getFeeCharged()) {
                        super.setBalance(getBalance() - item.getCost());
                    }

                    return true;
                }
            }
        } else {
            throw new IllegalArgumentException("Es wurden ungueltige Parameter ubergeben");
        }
        return false;
    }

    /**
     * Eine überschriebene accountData() Methode. Gibt die Informationen von Account und
     * PremiumAccount als String aus.
     * @return die account fdaten und Premium Account DATEN
     */
    @Override
    public String toString() {
        return "Account ID: " + super.getAccountId() + "; Balance: " + super.getBalance() + "; Inventory: " +  super.inText() +
                "; PremiumFee: " +  getPremiumFee() + "€" + "; Discount Rate: " + getDiscountRate() + "%" + "; FeeCharged: " + getFeeCharged();

    }

    /**
     * Überladen von equals(Object o): Überlade die Methode equals(Object o) in der Klasse Item mit der
     * Methode equals(Item i). Die equals-Methode soll true zurückgeben, wenn alle Attribute des this-Objekts
     * mit den Attributen des Parameterobjekts i übereinstimmen. Überlade die equals Methoden der Klassen
     * Account und PremiumAccount in der gleichen Form. Du kannst für den Vergleich des Array-Inhalts die equals-Methode von Item verwenden.
     * @param premA das premiumAccount Objekt
     * @throws IllegalArgumentException wenn der Paramter null ist
     */
    public boolean equals(PremiumAccount premA) {
        if(premA != null) {
            return this.premiumFee == premA.premiumFee && this.discountRate == premA.discountRate && this.feeCharged == premA.feeCharged;
        } else {
            throw new IllegalArgumentException("Ungueltige Paramter (ist null)");
        }
    }

    /**
     * Überschreiben hashCode(): Wenn die equals-Methode angepasst wird, muss auch die hashcode-Methoden der entsprechenden Klassen überschrieben werden. Verwende dazu folgende vereinfachte Formel zur Berechnung des Hashcodes:
     * Hashcode = Summe aus allen Zahlenwerten und den Hashcodes aller String-Werte
     * @return hashwert
     */
    @Override
    public int hashCode() {
        int oneOrZero = 0;
        if(feeCharged) {
            oneOrZero = 1;
        } else {
            oneOrZero = 0;
        }

        return (int) (premiumFee + discountRate + oneOrZero);
    }

}
