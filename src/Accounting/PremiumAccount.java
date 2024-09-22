package Accounting;
/**
 * This is Premium-Account
 * @author Isaac Jerryson
 * @version 15.03.2024
 */
public class PremiumAccount extends Account {
    private double premiumFee;
    private double discountRate;
    private boolean feeCharged;

    public PremiumAccount(int accountId, double balance, int positions, double premiumFee, double discountRate, boolean feeCharged) throws NegativeBalanceException {
        super(accountId, balance, positions);
        setPremiumFee(premiumFee);
        setDiscountRate(discountRate);
        setFeeCharged(feeCharged);
    }
    

    public double getPremiumFee() {
        return this.premiumFee;
    }

    public void setPremiumFee(double premiumFee) throws NegativeBalanceException {
        if (premiumFee >= 0.0) this.premiumFee = premiumFee;
        else throw new NegativeBalanceException();
    }

    public double getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(double discountRate){
        if (discountRate >= 0.0 && discountRate <= 100.0) this.discountRate = discountRate;
        else throw new IllegalArgumentException("Discount rate must be between 0.0 and 100.0");
    }

    public boolean isFeeCharged() {
        return this.feeCharged;
    }

    public void setFeeCharged(boolean feeCharged){
        this.feeCharged = feeCharged;
    }

    public void chargeMonthly() throws NegativeBalanceException {
        if (!feeCharged && getBalance() >= premiumFee) {
            setBalance(getBalance() - premiumFee);
            setFeeCharged(true);
        }
    }

    @Override
    public boolean buyItem(Item item) throws NegativeBalanceException {
        if (item != null) {
            if (getBalance() >= item.getCost()) {
                for (int i = 0; i < getInventory().length; i++) {
                    if (getInventory()[i] == null) {
                        getInventory()[i] = item;
                        setBalance(getBalance() - (item.getCost() * (getDiscountRate() / 100)));
                        return true;
                    }
                }
            }
            System.err.println("Sie haben nicht genügend Guthaben für dieses Item.");
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account-Data: \n" + super.toString() + "\nPremium-Account: \nPremium-Fee: " + getPremiumFee() + "\nDiscount-Rate: " + getDiscountRate() + "% \nFee-Charged: " + isFeeCharged();
    }

    /**
     * Überladen von equals(Object o): Überlade die Methode equals(Object o) in der Klasse Item mit der
     * Methode equals(Item i). Die equals-Methode soll true zurückgeben, wenn alle Attribute des this-Objekts
     * mit den Attributen des Parameterobjekts i übereinstimmen. Überlade die equals Methoden der Klassen
     * Account und PremiumAccount in der gleichen Form. Du kannst für den Vergleich des Array-Inhalts die equals-Methode von Item verwenden.
     * @param premA das premiumAccount Objekt
     * @throws IllegalArgumentException wenn der Paramter null ist
     */
    public boolean equals(jerryson.PremiumAccount premA) {
        if(premA != null) {
            return this.getPremiumFee() == premA.getPremiumFee() && this.getDiscountRate() == premA.getDiscountRate() && this.feeCharged == premA.feeCharged;
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
        }

        return (int) (premiumFee + discountRate + oneOrZero);
    }
}
