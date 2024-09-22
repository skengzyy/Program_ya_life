package jerryson;

/**
 * Die selbst geschriebene checkt Exception soll geworfen werden,
 * wenn versucht wird, das Attribut balance auf einen negativen Wert zu setzen.
 * (z.B. setBalance(), ...)
 * @author Isaac Jerryson
 * @version 2024-05-02
 */
public class NegativeBalanceException extends Exception {
    public NegativeBalanceException() {
        super("Negativer Balance");
    }
    public NegativeBalanceException(String text) {
        super(text);
    }


}
