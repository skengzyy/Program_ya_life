package jerryson;

import java.util.Objects;

/**
 * Basisklassen Account & Item zur Verwaltung eines Spieleraccounts: Du programmierst die Klassen zur
 * Accountverwaltung eines Mini-Spiels. In dem Spiel kannst du Items (z.b. Zaubertränke, ...) für deinen Charakter kaufen.
 * @author Isaac Jerryson
 * @version 2023-05-02
 */
public class Item extends NegativeBalanceException{
    // ATTRIBUTE
    private String name;
    private double cost;

    // KONSTRUKTOREN

    /**
     * Konstrukktor von Item
     * @param name Der Name des Items
     * @param cost Die Kosten des Gegenstands
     */
    public Item(String name, double cost) throws NegativeBalanceException {
        setName(name);
        setCost(cost);
    }

    /**
     * Konstrukktor von Item
     */
    public Item() {
        this.name = name;
        this.cost = cost;
    }

    //SETTER UND GETTER METHODEN

    /**
     * getter Methode fur Name
     * @return den namen
     */
    public String getName() {
        return name;
    }

    /**
     * setter Methode fur Name
     * @param name der Name der gesettet werden muss
     */
    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
    }

    /**
     * getter Methode fur Cost
     * @return die Kosten
     */
    public double getCost() {
        return cost;
    }

    /**
     * setter Methode für Cost
     * @param cost die Kosten
     */
    public void setCost(double cost) throws NegativeBalanceException {
        if(cost > 0) {
            this.cost = cost;
        } else {
            throw new NegativeBalanceException("Kosten musser höher als 0 sein");
        }
    }

    // METHODEN

    /**
     * fasst alle Attribute als String zusammen und gibt diesen zurück
     * @return die daten des Items
     */
    @Override
    public String toString() {
        return this.getName() + " (" + getCost() + "€)";
    }

    /**
     * Überladen von equals(Object o): Überlade die Methode equals(Object o) in der Klasse Item mit der
     * Methode equals(Item i). Die equals-Methode soll true zurückgeben, wenn alle Attribute des this-Objekts
     * mit den Attributen des Parameterobjekts i übereinstimmen. Überlade die equals Methoden der Klassen
     * Account und PremiumAccount in der gleichen Form. Du kannst für den Vergleich des Array-Inhalts die equals-Methode von Item verwenden.
     * @param item das Item Objekt
     * @throws IllegalArgumentException wenn item null ist
     */
    public boolean equals(Item item) {
        if(item != null) {
            return Objects.equals(this.name, item.name) && this.cost == item.cost;
        } else {
            throw new IllegalArgumentException("Item ist Null");
        }
    }

    /**
     * Überschreiben hashCode(): Wenn die equals-Methode angepasst wird, muss auch die hashcode-Methoden der entsprechenden Klassen überschrieben werden. Verwende dazu folgende vereinfachte Formel zur Berechnung des Hashcodes:
     * Hashcode = Summe aus allen Zahlenwerten und den Hashcodes aller String-Werte
     * @return hashwert
     */
    @Override
    public int hashCode() {
        return (int) (name.length() + cost);
    }
}
