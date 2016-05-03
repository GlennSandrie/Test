/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author anjana
 */
public enum Kleur
{

    GE(1, "GEEL"), B(2, "BLAUW"), R(3, "ROOD"), GR(4, "GROEN");

    private final int kleurNr;
    private final String kleurNaam;

    /**
     * methode om het kleurNr en de kleurnaam te initialiseren
     *
     * @param kleurNr
     * @param kleurNaam
     */
    Kleur(int kleurNr, String kleurNaam)
    {
        this.kleurNr = kleurNr;
        this.kleurNaam = kleurNaam;
    }

    /**
     * methode om het kleurNr te geven
     *
     * @return kleurNr kan 1, 2, 3 of 4 zijn
     */
    public int getKleurNr()
    {
        return kleurNr;
    }

    /**
     * methode om de kleurNaam te initialiseren
     *
     * @return kleurNaam kan geel, rood, groen of blauw zijn
     */
    public String getKleurNaam()
    {
        return kleurNaam;
    }
}
