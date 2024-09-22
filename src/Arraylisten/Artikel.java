package Arraylisten;
/**
 * Trenna cook this for my Broo
 * @author Isaac Jerryson
 * @version 11.03.2024
 */
public class Artikel {
    private int artNr;
    private String bez;
    private int gewicht;

    public Artikel(){
        setArtNr(1001);
        setBez("A-10");
        setGewicht(1);
    }

    public Artikel(int artNr, String bez, int gewicht){
        setArtNr(artNr);
        setBez(bez);
        setGewicht(gewicht);
    }


    /**
     * get field
     *
     * @return artNr
     */
    public int getArtNr() {
        return this.artNr;
    }

    /**
     * set field
     *
     * @param artNr
     */
    public void setArtNr(int artNr) {
        if(artNr >= 1001 && artNr <= 9999) this.artNr = artNr;
        else this.artNr = 1001;
    }

    /**
     * get field
     *
     * @return bez
     */
    public String getBez() {
        return this.bez;
    }

    /**
     * set field
     *
     * @param bez
     */
    public void setBez(String bez) {
        if(bez.length() >= 4) this.bez = bez;
        else this.bez = "A-10";
    }

    /**
     * get field
     *
     * @return gewicht
     */
    public int getGewicht() {
        return this.gewicht;
    }

    /**
     * set field
     *
     * @param gewicht
     */
    public void setGewicht(int gewicht) {
        if(gewicht >= 10 && gewicht <= 100) this.gewicht = gewicht;
        else this.gewicht = 1;
    }
    /*
    IDK if you're using the one from the superclass "Object"
    but it'd look like this init

    @Override
    public String toString() {
        return super.toString();
    }
     */

    @Override
    public String toString() {
        StringBuilder ArtikelInfo = new StringBuilder();
        ArtikelInfo.append("Artikelnummer lautet: ").append(getArtNr());
        ArtikelInfo.append(", Bezeichnung: ").append(getBez());
        ArtikelInfo.append(", Gewicht: ").append(getGewicht()).append("g");
        return ArtikelInfo.toString();
    }
}