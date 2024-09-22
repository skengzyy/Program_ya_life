package Arraylisten;

import java.util.ArrayList;

/**
 * Trenna cook this for my Bro,
 * So for this one I'll use comments cus it gets
 * a bit complicated on why I do what I do
 * -------------------------------------------**
 * Listening to Outside by Dayo Bello, Odeal  ||^
 * -------------------------------------------**w
 * @author Isaac Jerryson
 * @version 11.03.2024
 */
public class Katalog {
    private int max;//Attribute: maximum amount of Article's
    private ArrayList<Artikel> liste;//Arraylist containing thr Articles

    public Katalog(ArrayList<Artikel> liste){
        this.liste = liste = new ArrayList<>(30);
    }
    public Katalog(int max, ArrayList<Artikel> liste){
        setListe(max);
    }


    public ArrayList<Artikel> getListe() {
        return liste;
    }

    public void setListe(int capacity) {
        this.liste = new ArrayList<>(capacity);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        if(max >= 10 && max <= 100) setListe(max);
        else setListe(30);
    }

    public void listeAnzeigen() {
        for (Artikel artikel : this.liste) {
            System.out.println(artikel.toString());
        }
    }

    public int anzahl(){
        int anzahlArtikel = 0;

        for(Artikel artikel : this.liste){
            if(artikel != null) anzahlArtikel++;
        }
        return anzahlArtikel;
    }

    public boolean enthalten(int artNr){
        for(Artikel artikel : this.liste){
            if(artikel != null){
                if(artikel.getArtNr() == artNr) return true;
            }
        }
        return false;
    }

    public void artikelEintragen(Artikel artikel){
       if(artikel != null && getListe() != null){
           getListe().add(artikel);
       }
    }

}