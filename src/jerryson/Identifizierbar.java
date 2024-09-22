package jerryson;

/**
 * Hiermit werden alle Objekte gekennzeichnet, die eine Textuelle ID von mindestens 15
 * Stellen zurückgeben können.
 * @author Isaac Jerryson
 * @version 02.05.2024
 */
public interface Identifizierbar {
    /**
     * Diese Methode gibt eine ID-Bezeichnung mit mindestens 10 Stellen zurück
     * @return eine ID als Text mit mindestens 10 Zeichen.
     */
    void identifier();
}
