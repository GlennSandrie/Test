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

    Kleur(int kleurNr, String kleurnaam) 
    {
        this.kleurNr = kleurNr;
        this.kleurNaam = kleurnaam;
    }
    
    public int getKleurNr()
    {
        return kleurNr;
    }
    
    public String getKleurNaam()
    {
        return kleurNaam;
    }
}
