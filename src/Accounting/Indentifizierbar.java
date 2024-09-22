package Accounting;
/**
 * This is the Interface for the Identifier class
 * @author Isaac Jerryoson
 * @version 14.05.2024
 */
public interface Indentifizierbar {
    /**
     * Methode identifier muss eine AccountID,
     * die weniger als 10 Stellen hat durch führende
     * 0 Ziffern auf 10 Stellen vergrößert werden.
     * Der Wert von accountID selbst soll als int
     * mit ursprünglichem Wert erhalten bleiben.
     */
    public void identifier();
}