package Accounting;

import java.util.Objects;

/**
 * This is an Item
 * @author Isaac Jerryson
 * @version 14.03.2024
 */

public class Item {
    private String name;
    private double cost;

    public Item(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    /**
     * get field
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set field
     *
     * @param name
     */
    public void setName(String name) {
        if(name != null) this.name = name;
        else this.name = "Name";
    }

    /**
     * get field
     *
     * @return cost
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * set field
     *
     * @param cost
     */
    public void setCost(double cost) {
        if(cost >= 0) this.cost = cost;
        else this.cost = 0.0; // Set to 0 if negative
    }

    public String itemData() {
        return "Item-Name: " + this.getName() + " Item-Cost: " + this.getCost() + "€";
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
            return Objects.equals(this.name, item.getName()) && this.cost == item.getCost();
        } else {
            throw new IllegalArgumentException("Item ist Null");
        }
    }


}